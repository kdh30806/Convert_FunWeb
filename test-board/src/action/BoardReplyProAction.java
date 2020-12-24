package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.BoardBean;
import service.BoardWriteProService;
import vo.ActionForward;

public class BoardReplyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ActionForward forward = null;
		
		String realFolder = "";
		String saveFolder = "/upload";
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		BoardBean bb = new BoardBean();
		bb.setName(multi.getParameter("name"));
		bb.setSubject(multi.getParameter("subject"));
		bb.setContent(multi.getParameter("content"));
		bb.setFile(multi.getFilesystemName("file"));
		bb.setOriginFile(multi.getOriginalFileName("file"));
		bb.setRe_ref(Integer.parseInt(multi.getParameter("re_ref")));
		bb.setRe_lev(Integer.parseInt(multi.getParameter("re_lev"))+1);
		bb.setRe_seq(Integer.parseInt(multi.getParameter("re_seq"))+1);
		
		BoardWriteProService service = new BoardWriteProService();
		service.updateRe_seq(bb.getRe_ref(), bb.getRe_seq());
		service.wrtieBoard(bb);
		
		forward = new ActionForward();
		forward.setPath("main.bo");
		forward.setRedirect(true);
		return forward;
	}

}
