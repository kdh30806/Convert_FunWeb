package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import bean.SearchCri;
import service.BoardDetailService;
import vo.ActionForward;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		int num =  Integer.parseInt(request.getParameter("num"));   		
		String search = request.getParameter("search");
		String searchFlag = request.getParameter("searchFlag");
		String pageNum = request.getParameter("pageNum");
		
		SearchCri scri = new SearchCri(searchFlag, search, pageNum);
		BoardDetailService service = new BoardDetailService();
		BoardBean bb = service.getBoard(num);
		
		request.setAttribute("scri", scri);
		request.setAttribute("bb", bb);
		
		forward = new ActionForward();
		forward.setPath("detail.jsp");
		return forward;
	}

}
