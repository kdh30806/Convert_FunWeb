package service;

import java.sql.Connection;
import java.util.ArrayList;
import static vo.JDBCUtill.*;

import bean.BoardBean;
import dao.BoardDAO;
import dao.PageDAO;
import dao.PageMaker;


public class BoardMainService {

	public ArrayList<BoardBean> getBoardList(String pageNum) {
		
		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		PageDAO pd = new PageDAO();
		pd.setPageNum(pageNum);
		pd.setCount(bd.getBoardCount());
		
		ArrayList<BoardBean> boardList = bd.getBoardList(pd);
		
		return boardList;
	}
	
	public PageMaker getPageMaker(String pageNum) {
		
		Connection con = getConnection();
		
		BoardDAO bd = BoardDAO.getInstance();
		
		bd.setConnection(con);
		
		PageDAO pd = new PageDAO();
		pd.setPageNum(pageNum);
		pd.setCount(bd.getBoardCount());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageDAO(pd);
		
		return pageMaker;
		
	}

}
