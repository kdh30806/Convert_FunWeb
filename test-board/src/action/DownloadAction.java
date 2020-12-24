package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class DownloadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String fileName = request.getParameter("file");
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String filePath = path + "\\" + fileName;
		File file = new File(filePath);
		
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);

		String encoding = new String(fileName.getBytes("utf-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment; filename= " + encoding);
		
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();
		
		byte b[] = new byte[4096];
		int data = 0;
		while((data = in.read(b, 0, b.length)) != -1) {
			outputStream.write(b, 0, data);
		}
		
		outputStream.flush();
		outputStream.close();
		in.close();
		
		return null;
	}

}
