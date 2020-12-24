package dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static vo.JDBCUtill.*;

import bean.BoardBean;
import bean.PageBean;

public class BoardDAO {

	Connection con;

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int maxNum() {

		int num = 0;
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select max(board_num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return num;
	}
	
	public int updateRe_seq(int re_ref, int re_seq) {

		PreparedStatement pstmt = null;

		try {
			String sql = "update board set re_seq=re_seq+1  where re_ref=? and re_seq>=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return 0;
	}

	public int wrtieBoard(BoardBean bb) {

		PreparedStatement pstmt = null;

		try {
			Clob clob = con.createClob();
			clob.setString(1, bb.getContent());

			String sql = "insert into board values(?,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, maxNum());
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getSubject());
			pstmt.setClob(4, clob);
			pstmt.setString(5, bb.getFile());
			pstmt.setString(6, bb.getOriginFile());
			if(bb.getRe_lev() == 0) {
				pstmt.setInt(7, maxNum());			
			} else {
				pstmt.setInt(7, bb.getRe_ref());
			}
			pstmt.setInt(8, bb.getRe_lev());
			pstmt.setInt(9, bb.getRe_seq());
			pstmt.setInt(10, 0);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return 0;
	}

	public ArrayList<BoardBean> getBoardList(PageBean pd) {

		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from (select ROW_NUMBER() over (order by re_ref desc, re_seq) NUM,  b.* from board b order by re_ref desc, re_seq) where NUM between ?and?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pd.getStartRow());
			pstmt.setInt(2, pd.getEndRow());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean bb = new BoardBean();

				bb.setNum(rs.getInt("board_num"));
				bb.setName(rs.getString("board_name"));
				bb.setSubject(rs.getString("board_subject"));
				bb.setContent(rs.getString("board_content"));
				bb.setFile(rs.getString("board_file"));
				bb.setOriginFile(rs.getString("board_originfile"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setRead_count(rs.getInt("read_count"));

				boardList.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}

	public BoardBean getBoard(int num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean bb = new BoardBean();

		try {
			String sql = "select * from board where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bb.setNum(rs.getInt("board_num"));
				bb.setName(rs.getString("board_name"));
				bb.setSubject(rs.getString("board_subject"));
				bb.setContent(rs.getString("board_content"));
				bb.setFile(rs.getString("board_file"));
				bb.setOriginFile(rs.getString("board_originfile"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setRead_count(rs.getInt("read_count"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return bb;
	}

	public int deleteBoard(int num) {

		PreparedStatement pstmt = null;

		try {
			String sql = "delete from board where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return 0;
	}

	public int updateBoard(BoardBean bb) {

		PreparedStatement pstmt = null;

		try {
			String sql = "update board set board_subject=?,board_content=?,board_file=? where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bb.getSubject());
			pstmt.setString(2, bb.getContent());
			pstmt.setString(3, bb.getFile());
			pstmt.setInt(4, bb.getNum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return 0;
	}

	public int getBoardCount() {

		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return count;
	}
	
	public int getBoardCount(String search) {

		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from board where board_subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return count;
	}

	public ArrayList<BoardBean> getSearchList(String search, PageBean pd) {
		
		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from (select ROW_NUMBER() over (order by re_ref desc, re_seq) NUM,  b.* from board b where board_subject like ? order by re_ref desc, re_seq) where NUM between ?and?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, pd.getStartRow());
			pstmt.setInt(3, pd.getEndRow());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean bb = new BoardBean();

				bb.setNum(rs.getInt("board_num"));
				bb.setName(rs.getString("board_name"));
				bb.setSubject(rs.getString("board_subject"));
				bb.setContent(rs.getString("board_content"));
				bb.setFile(rs.getString("board_file"));
				bb.setOriginFile(rs.getString("board_originfile"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setRead_count(rs.getInt("read_count"));

				boardList.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	public int updateReadCount(int num) {
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board set read_count=read_count+1 where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,	num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return 0;
	}


}
