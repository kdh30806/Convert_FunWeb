package service;

import bean.BoardBean;
import dao.BoardDAO;

import static vo.JDBCUtill.*;

import java.sql.Connection;

public class BoardDetailService {

	public BoardBean getBoard(int num) {
		
		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		BoardBean bb = bd.getBoard(num);
		
		return bb;
	}

}
