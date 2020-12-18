package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteService;
import vo.ActionForward;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDeleteService service = new BoardDeleteService();
		service.deleteBoard(num);
		
		forward = new ActionForward();
		forward.setPath("main.bo");
		return forward;
	}

}
