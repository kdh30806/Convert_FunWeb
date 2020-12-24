package service;

import java.sql.Connection;
import java.util.ArrayList;
import static vo.JDBCUtill.*;

import bean.BoardBean;
import bean.PageBean;
import dao.BoardDAO;

public class BoardSearchService {

	public ArrayList<BoardBean> getSearchList(String search, String pageNum) {

		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		PageBean pd = new PageBean();
		pd.setPageNum(pageNum);
		pd.setCount(bd.getBoardCount(search));
		
		ArrayList<BoardBean> searchList = bd.getSearchList(search, pd);
		
		close(con);
		
		return searchList;
	}

}
