package service;

import static vo.JDBCUtill.*;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardDeleteService {

	public void deleteBoard(int num) {

		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		int isSuccess = bd.deleteBoard(num);
		
		if(isSuccess > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
	}
	
}
