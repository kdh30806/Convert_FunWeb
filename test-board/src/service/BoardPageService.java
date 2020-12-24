package service;

import static vo.JDBCUtill.*;

import java.sql.Connection;
import bean.PageBean;
import bean.PageMaker;
import dao.BoardDAO;

public class BoardPageService {

	public PageMaker getPageMaker(String pageNum) {

		Connection con = getConnection();

		BoardDAO bd = BoardDAO.getInstance();

		bd.setConnection(con);

		PageBean pb = new PageBean();
		pb.setPageNum(pageNum);
		pb.setCount(bd.getBoardCount());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageDAO(pb);
		
		close(con);
		
		return pageMaker;

	}
	
	public PageMaker getPageMaker(String pageNum, String search) {

		Connection con = getConnection();

		BoardDAO bd = BoardDAO.getInstance();

		bd.setConnection(con);

		PageBean pb = new PageBean();
		pb.setPageNum(pageNum);
		pb.setCount(bd.getBoardCount(search));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageDAO(pb);

		close(con);
		
		return pageMaker;

	}

}
