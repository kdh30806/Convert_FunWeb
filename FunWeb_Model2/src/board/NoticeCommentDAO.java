package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeCommentDAO {

	public Connection getConnection() {

		String dbUrl = "jdbc:mysql://localhost:3306/jspdb5";
		String dbUser = "root";
		String dbPass = "1234";
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return con;
	}

	public void insertComment(CommentBean cb) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			String sql = "select max(num) from noticeComment";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				cb.setNum(rs.getInt("max(num)") + 1);
			}

			sql = "insert into noticeComment(num,name,content,date,ref) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, cb.getNum());
			pstmt.setString(2, cb.getName());
			pstmt.setString(3, cb.getContent());
			pstmt.setTimestamp(4, cb.getDate());
			pstmt.setInt(5, cb.getRef());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {	rs.close();} catch (SQLException e) {}
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
		
	}
	
	public List<CommentBean> getBoardList(int ref) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentBean> list = new ArrayList<CommentBean>();
		
	
		try {
			con = getConnection();
			String sql = "select * from noticeComment where ref=? order by num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentBean cb = new CommentBean();
				cb.setNum(rs.getInt("num"));
				cb.setName(rs.getString("name"));
				cb.setContent(rs.getString("content"));
				cb.setDate(rs.getTimestamp("date"));
				cb.setRef(rs.getInt("ref"));
				list.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {	rs.close();} catch (SQLException e) {}
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
		
		return list;	
	}
}
