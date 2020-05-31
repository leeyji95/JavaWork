package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.D;

public class UserDAO {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	// DAO 객체가 생성될때 Connection 도 생성된다.
	public UserDAO() {

		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("UserDAO 생성, 데이터 베이스 연결!");
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	} // 생성자

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	} // end close()

	
	public int insert(UserDTO dto) {
		try {

			pstmt = conn.prepareStatement(D.SQL_INSERT);
			pstmt.setString(1, dto.getUserID());
			pstmt.setString(2, dto.getUserPassword());
			pstmt.setString(3, dto.getUserEmail());
			pstmt.setString(4, dto.getUserEmailHash());
			
			return pstmt.executeUpdate();  // insert 성공하면 1 리턴

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return -1; // 회원가입 실패

	}
	
	
	// 메서드 오버로딩
	   public int insert(String userID, String userPassword, String userEmail, String userEmailHash) throws SQLException {

	      int cnt = 0;
	      try {
	         pstmt = conn.prepareStatement(D.SQL_INSERT);
	         pstmt.setString(1, userID);
	         pstmt.setString(2, userPassword);
	         pstmt.setString(3, userEmail);
	         pstmt.setString(4, userEmailHash);

	         cnt = pstmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return cnt;
	   }//end insert
	
	public String select_get_userEmail(String user_id) {
		try {

			pstmt = conn.prepareStatement(D.SQL_GET_EMAIL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				return rs.getString(1); // 이메일 주소 문자열 리턴
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; // 데이터베이스 오류
	}
	
	
	
	public String select_email_check(String user_id) {
		try {

			pstmt = conn.prepareStatement(D.SQL_EMAIL_CHECK);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				return rs.getString("user_emailchecked"); // 이메일 등록 여부 반환
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "0"; // 데이터베이스 오류
	}
	
	
	public String setUserEmailChecked(String user_id) {

		try {

			pstmt = conn.prepareStatement(D.SQL_SET_EMAIL_CHECK);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();

			return "1"; // 이메일 등록 설정 성공
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0"; // 이메일 등록 설정 실패
	}

}




	
	
	
	

