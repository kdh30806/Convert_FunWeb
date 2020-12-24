package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
