package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Data Access Logic Object
/*
 * MemberDAO는 웹 어플리케이션 상에서 하나만 존재한다.
 * Singleton Pattern을 적용하여 외부에서 객체생성하는 것을 막고
 * 한번 생성한 객체를 공유하여 사용하게 한다.
 */
public class MemberDAO {
	//class loading 시점에 단 한번 객체 생성하여 method area에 적재
	private static MemberDAO instance = new MemberDAO();
	// 외부에서 생성 못하게 private 처리
	private MemberDAO(){}
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

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DbInfo.URL,"scott","tiger");
	}
	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select password,name,address from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	public MemberVO loginMember(String id,String password) throws SQLException{
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select id,name,address from member where id =? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()){
				vo = new MemberVO(rs.getString(1),null,rs.getString(2),rs.getString(3));
			}
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		return vo;
		
	}
	public ArrayList<MemberVO> findMemberByAddress(String address) throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select id,name from member where address = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new MemberVO(rs.getString(1),rs.getString(2)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public void updateMember(MemberVO vo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "update member set password = ?, name =?,address = ? where id =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		}finally{
			closeAll(rs, pstmt, con);
		}
	}
	
	public int getMemberCount() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con =getConnection();
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return cnt;
	}
}
