package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteAction;
import action.BoardDetailAction;
import action.BoardMainAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardSearchAction;
import action.BoardUpdateFormAction;
import action.BoardUpdateProAction;
import action.BoardWriteProAction;
import action.DownloadAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}
	
	protected void doProcces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath();
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/main.bo")) {
			action = new BoardMainAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardWriteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("write.jsp");
		} else if(command.equals("/BoardWritePro.bo")) {
			action = new BoardWriteProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/detail.bo")) {
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		} else if(command.equals("/delete.bo")) {
			action = new BoardDeleteAction();
			forward = action.execute(request, response);
		} else if(command.equals("/updateForm.bo")) {
			action = new BoardUpdateFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/updatePro.bo")) {
			action = new BoardUpdateProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/download.bo")) {
			action = new DownloadAction();
			forward = action.execute(request, response);
		} else if(command.equals("/replyForm.bo")) {
			action = new BoardReplyFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/replyPro.bo")) {
			action = new BoardReplyProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/search.bo")) {
			action = new BoardSearchAction();
			forward = action.execute(request, response);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}

}
