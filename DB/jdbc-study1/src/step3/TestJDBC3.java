package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Update SQL �����ϴ� ����
 */
public class TestJDBC3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String name = "Ȳ����";
		String address = "���";
		// Ȳ���� name�� member�� address�� ������� ������Ʈ
		try {
			Class.forName(driver);
			System.out.println("����ŬDB ����̹� �ε�");
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("����Ŭ �����ͺ��̽� ����");
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
