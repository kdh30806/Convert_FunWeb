package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import service.BoardDeleteService;
import service.BoardDetailService;
import vo.ActionForward;

public class BoardReplyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDetailService service = new BoardDetailService();
		
		BoardBean bb = service.getBoard(num);
		
		request.setAttribute("bb", bb);
		
		forward = new ActionForward();
		forward.setPath("reply.jsp?num="+num);
		return forward;
	}

}
