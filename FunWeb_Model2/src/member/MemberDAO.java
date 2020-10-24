package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	public Connection getConnection() throws Exception {

//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb5";
//		String dbUser = "root";
//		String dbPass = "1234";
//		Connection con = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
//			System.out.println("드라이버 연결 완료");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return con;
		
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con = ds.getConnection();
		
		return con;
		}

	public void insertMember(MemberBean mb) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "insert into member(id,pass,name,age,gender,email,zipNo,address,address2,address3,phone,mobile,reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setInt(4, mb.getAge());
			pstmt.setString(5, mb.getGender());
			pstmt.setString(6, mb.getEmail());
			pstmt.setString(7, mb.getZipNo());
			pstmt.setString(8, mb.getAddress());
			pstmt.setString(9, mb.getAddress2());
			pstmt.setString(10, mb.getAddress3());
			pstmt.setString(11, mb.getPhone());
			pstmt.setString(12, mb.getMobile());
			pstmt.setTimestamp(13, mb.getReg_date());
			pstmt.executeUpdate();
			System.out.println("인서트 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}

	}

	public MemberBean getMember(String id) {

		MemberBean mb = new MemberBean();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConnection();

			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				mb.setZipNo(rs.getString("zipNo"));
				mb.setAddress(rs.getString("address"));
				mb.setAddress2(rs.getString("address2"));
				mb.setAddress3(rs.getString("address3"));
				mb.setPhone(rs.getString("phone"));
				mb.setMobile(rs.getString("mobile"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
		return mb;
		}
	
	public int checkMember(String id, String pass) {
		
		int check = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 0;
				if(pass.equals(rs.getString("pass"))){
					check = 1;
				}
			}
			else {
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
				
		return check;
		
	}
	
	
	public void updateMember(MemberBean mb) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "update member set age=?,gender=?,email=?,zipNo=?,address=?,address2=?,address3=?,phone=?,mobile=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mb.getAge());
			pstmt.setString(2, mb.getGender());
			pstmt.setString(3, mb.getEmail());
			pstmt.setString(4, mb.getZipNo());
			pstmt.setString(5, mb.getAddress());
			pstmt.setString(6, mb.getAddress2());
			pstmt.setString(7, mb.getAddress3());
			pstmt.setString(8, mb.getPhone());
			pstmt.setString(9, mb.getMobile());
			pstmt.setString(10, mb.getId());

			pstmt.executeUpdate();
			System.out.println("수정 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}

	}
	
	public void deleteMember(String id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
	}
	
	public List getMemberList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		
		try {
			con = getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				list.add(mb);

			}
			System.out.println("리스트 업데이트 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
		return list;
	}
	
	public int dupCheck(String id) {
		
		int check = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
			else {
				check = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {	pstmt.close();} catch (SQLException e2) {}
			if(con != null) try{ con.close();} catch (SQLException e3) {}
		}
				
		System.out.println(check);
		return check;
		
	}
}
