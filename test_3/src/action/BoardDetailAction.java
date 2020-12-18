package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import service.BoardDetailService;
import vo.ActionForward;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		int num =  Integer.parseInt(request.getParameter("num"));   
		
		BoardDetailService service = new BoardDetailService();
		BoardBean bb = service.getBoard(num);
		
		request.setAttribute("bb", bb);
		
		forward = new ActionForward();
		forward.setPath("detail.jsp");
		return forward;
	}

}
