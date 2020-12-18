package action;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.BoardBean;
import service.BoardWriteProService;
import vo.ActionForward;
import static vo.JDBCUtill.*;

public class BoardWriteProAction implements Action{

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
		
		BoardWriteProService service = new BoardWriteProService();
		service.wrtieBoard(bb);
		
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("main.bo");
		
		return forward;
	}

}
