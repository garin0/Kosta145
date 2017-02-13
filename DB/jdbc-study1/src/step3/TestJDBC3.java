package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Update SQL 실행하는 예제
 */
public class TestJDBC3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String name = "황윤상";
		String address = "평양";
		// 황윤상 name인 member의 address를 평양으로 업데이트
		try {
			Class.forName(driver);
			System.out.println("오라클DB 드라이버 로딩");
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("오라클 데이터베이스 연결");
			String sql = "update member set address=? where name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, name);
			System.out.println("update count:" + pstmt.executeUpdate());
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
