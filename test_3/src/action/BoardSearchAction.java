package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import dao.PageMaker;
import service.BoardPageService;
import service.BoardSearchService;
import vo.ActionForward;

public class BoardSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ActionForward forward = null;

		String search = request.getParameter("search");
		String searchFlag = request.getParameter("searchFlag");
		String pageNum = request.getParameter("pageNum");

		BoardSearchService service = new BoardSearchService();
		BoardPageService service2 = new BoardPageService();

		ArrayList<BoardBean> boardList = service.getSearchList(search, pageNum);
		PageMaker pageMaker = service2.getPageMaker(pageNum, search);

		request.setAttribute("search", search);
		request.setAttribute("searchFlag", searchFlag);
		request.setAttribute("page", pageMaker);
		request.setAttribute("boardList", boardList);
		
		forward = new ActionForward();
		forward.setPath("main.jsp");
		return forward;
	}

}
