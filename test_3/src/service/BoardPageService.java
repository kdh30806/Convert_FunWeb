package service;

import static vo.JDBCUtill.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import dao.PageDAO;
import dao.PageMaker;

public class BoardPageService {

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
	
	public PageMaker getPageMaker(String pageNum, String search) {

		Connection con = getConnection();

		BoardDAO bd = BoardDAO.getInstance();

		bd.setConnection(con);

		PageDAO pd = new PageDAO();
		pd.setPageNum(pageNum);
		pd.setCount(bd.getBoardCount(search));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageDAO(pd);

		return pageMaker;

	}

}
