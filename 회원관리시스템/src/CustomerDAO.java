import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CustomerDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String ip;
	
	private CustomerDAO() {}
	
	private static CustomerDAO instance = new CustomerDAO();

	public static final CustomerDAO getInstance() {
		return instance;
	}
	
	// DB 연결 작업 수행 후 연결 객체(Connection) 를 리턴하는 getConnection() 메서드 정의
	public Connection getConnection(String ip) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://" + ip + ":3306/hyuni";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return con;
	}
	
	// 데이터베이스 자원 반환(close()) 메서드
	private void closeDb() {
		if(rs != null) try { rs.close(); } catch (Exception e) {}
		if(pstmt != null) try { pstmt.close(); } catch (Exception e) {}
		if(con != null) try { con.close(); } catch (Exception e) {}
	}
	
	// IP주소, 계정명, 패스워드를 전달받아 로그인 기능을 수행하는 login() 메서드 정의
	public boolean login(String ip, String dbUsername, String dbPassword) throws LoginFailException {
		this.ip = ip;
		
		// getConnection() 메서드를 호출하여 Connection 객체 가져오기
		con = getConnection(ip);
		
		boolean result = false; // 로그인 결과
		
		try {
			String sql = "SELECT pass FROM member2 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dbUsername);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(dbPassword.equals(rs.getString(1))) {
					result = true;
				} else {
					throw new LoginFailException("패스워드 틀림");
				}
			} else {
				throw new LoginFailException("존재하지 않는 아이디");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDb();
		}
		
		return result;
	}

	// 이름, 아이디, 패스워드, 주민번호를 전달받아 customer 테이블에 추가 후 성공 여부 리턴
	public boolean insert(String name, String id, String password, String jumin) {
		boolean result = false;
		
		con = getConnection(ip);
		
		try {
			// DTO 객체에 저장된 데이터를 DB 에 INSERT
			String sql = "INSERT INTO member2 VALUES (null,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, jumin);
			
			int insertCount = pstmt.executeUpdate();
			
			if(insertCount > 0) {
				result = true;
			}

		} catch (SQLException e) {
			System.out.println("SQL 구문 오류! - " + e.getMessage());
		} finally {
			closeDb();
		}
		
		return result;
	}
	
	public boolean delete(int idx) {
		boolean result = false; // 회원 삭제 성공 여부
		
		con = getConnection(ip);
		
		try {
			// 전달받은 번호(idx)를 사용하여 레코드 삭제
			String sql = "DELETE FROM member2 WHERE idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			int deleteCount = pstmt.executeUpdate();
			
			if(deleteCount > 0) {
				result = true;
			}

		} catch (SQLException e) {
			System.out.println("SQL 구문 오류! - " + e.getMessage());
		} finally {
			closeDb();
		}
		
		return result;
	}
	
	public Vector<Vector> select() {
		con = getConnection(ip);
		
		try {
			String sql = "SELECT * FROM member2";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 전체 레코드를 저장할 Vector 객체
			Vector<Vector> data = new Vector<Vector>(); 
			
			while(rs.next()) {
				Vector rowData = new Vector<>(); // 1개 레코드를 저장할 Vector 객체
				
				rowData.add(rs.getInt("idx"));
				rowData.add(rs.getString("name"));
				rowData.add(rs.getString("id"));
				rowData.add(rs.getString("pass"));
				rowData.add(rs.getString("jumin"));
				
				data.add(rowData);
			}
			
			return data; // 조회 성공 시 저장된 Vector 객체 리턴
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류! - " + e.getMessage());
		} finally {
			closeDb();
		}
		
		return null;
	}
	
}





















