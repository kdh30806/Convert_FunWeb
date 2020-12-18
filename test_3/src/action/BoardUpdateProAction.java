package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardBean;
import service.BoardUpdateProService;
import vo.ActionForward;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String file = request.getParameter("file");

		BoardBean bb = new BoardBean();
		bb.setNum(num);
		bb.setSubject(subject);
		bb.setContent(content);
		bb.setFile(file);

		BoardUpdateProService service = new BoardUpdateProService();
		service.updateBoard(bb);

		forward = new ActionForward();
		forward.setPath("detail.bo?num="+num);
		return forward;
	}

}
