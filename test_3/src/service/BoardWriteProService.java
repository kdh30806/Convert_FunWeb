package service;

import java.sql.Connection;

import bean.BoardBean;
import dao.BoardDAO;

import static vo.JDBCUtill.*;

public class BoardWriteProService {

	public void wrtieBoard(BoardBean bb) {

		Connection con = getConnection();

		BoardDAO bd = BoardDAO.getInstance();

		bd.setConnection(con);

		int isSuccess = bd.wrtieBoard(bb);

		if (isSuccess > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
	}

	public void updateRe_seq(int re_ref, int re_seq) {

		Connection con = getConnection();

		BoardDAO bd = BoardDAO.getInstance();

		bd.setConnection(con);

		int isSuccess = bd.updateRe_seq(re_ref, re_seq);

		if (isSuccess > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
	}

}
