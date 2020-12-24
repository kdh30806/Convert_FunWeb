package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import bean.PageMaker;
import bean.SearchCri;
import service.BoardMainService;
import service.BoardPageService;
import service.BoardSearchService;
import vo.ActionForward;

public class BoardMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
			
		String search = request.getParameter("search");
		String searchFlag = request.getParameter("searchFlag");
		String pageNum = request.getParameter("pageNum");
		
		PageMaker pageMaker = null;
		ArrayList<BoardBean> boardList = null;
		SearchCri scri = new SearchCri(searchFlag, search, pageNum);
		
		BoardMainService service = new BoardMainService();
		BoardSearchService service2 = new BoardSearchService();
		BoardPageService service3 = new BoardPageService();
		
		if(searchFlag == null || searchFlag == "false") {
			boardList = service.getBoardList(pageNum);
			pageMaker = service3.getPageMaker(pageNum);			
		}else {
			boardList = service2.getSearchList(search, pageNum);
			pageMaker = service3.getPageMaker(pageNum, search);	
		}
		
		request.setAttribute("scri", scri);
		request.setAttribute("page", pageMaker);
		request.setAttribute("boardList", boardList);
		
		forward = new ActionForward();
		forward.setPath("main.jsp");
		return forward;
	}

}
