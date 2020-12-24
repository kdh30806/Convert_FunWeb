package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.BoardBean;
import service.BoardUpdateProService;
import vo.ActionForward;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = null;
		
		String realFolder = "";
		String saveFolder = "/upload";
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		int num = Integer.parseInt(multi.getParameter("num"));
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String file = multi.getParameter("file");

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
