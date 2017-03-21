package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
		private static MemberDAO instance = new MemberDAO();
		private DataSource dataSource;
		private MemberDAO(){
			dataSource=DataSourceManager.getInstance().getDataSource();
		}
		//외부에 현 객체 레퍼런스를 공유
		public static MemberDAO getInstance(){
			return instance;
		}
		public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		private Connection getConnection() throws SQLException{
			return dataSource.getConnection();
		}
		
		public MemberVO loginMember(String id,String password) throws SQLException{
			MemberVO vo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select id,password,name from login_member where id=? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if (rs.next()){
					vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3));
				}
				
			}finally{
				closeAll(rs, pstmt, con);
			}
			return vo;
			
		}
		public String findNameById(String id) throws SQLException{
			String mid = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				String sql = "select name from login_member where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()){
					mid = rs.getString(1);
				}
				
			}finally{
				closeAll(rs, pstmt, con);
			}
			return mid;
		}
}
