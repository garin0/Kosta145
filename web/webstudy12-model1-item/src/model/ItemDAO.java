package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
	private static ItemDAO instance = new ItemDAO();
	// 외부에서 생성 못하게 private 처리
	private ItemDAO(){}
	//외부에 현 객체 레퍼런스를 공유
	public static ItemDAO getInstance(){
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

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}
	
	public void registerItem(ItemVO vo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "insert into item(item_no,name,maker,price) values(item_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMaker());
			pstmt.setInt(3, vo.getPrice());
			pstmt.executeQuery();
		}finally{
			closeAll(pstmt, con);
		}
	}
	public ArrayList<ItemVO> listItem() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		try{
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select item_no,name from item  order by item_no asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			 list.add(new ItemVO(rs.getInt(1), rs.getString(2)));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
		
	}
	
	public ArrayList<ItemVO> detailItem() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		try{
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select item_no,name,maker,price from item  order by item_no asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			 list.add(new ItemVO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
		
	}
}
