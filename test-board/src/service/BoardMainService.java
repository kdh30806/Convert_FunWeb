package service;

import java.sql.Connection;
import java.util.ArrayList;
import static vo.JDBCUtill.*;

import bean.BoardBean;
import bean.PageBean;
import dao.BoardDAO;


public class BoardMainService {

	public ArrayList<BoardBean> getBoardList(String pageNum) {
		
		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		PageBean pd = new PageBean();
		pd.setPageNum(pageNum);
		pd.setCount(bd.getBoardCount());
		
		ArrayList<BoardBean> boardList = bd.getBoardList(pd);
		
		close(con);
		
		return boardList;
	}
}
