package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO:Data Access Object
 * 데이터베이스 연동을 위한 객체
 */
public class MemberDAO {

	public MemberDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {

		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
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

	public void registerMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "insert into member(id,password,name,address) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		} finally {
			closeAll(null, pstmt, con);

		}

	}

	public ArrayList<MemberVO> getAllMemberList() throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select * from member order by id asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public void updateMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "update member set password = ?,name= ?,address= ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public int getMemberCountByAddress(String address) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select count(*) from member where address= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
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
