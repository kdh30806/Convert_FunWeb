package service;

import java.sql.Connection;
import static vo.JDBCUtill.*;

import bean.BoardBean;
import dao.BoardDAO;

public class BoardUpdateProService {

	public void updateBoard(BoardBean bb) {

		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		int isSuccess = bd.updateBoard(bb);
		
		if(isSuccess > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
	}

}
