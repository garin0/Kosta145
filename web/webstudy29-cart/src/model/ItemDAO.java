package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * Singleton Pattern 적용 : 시스템 상에서 한번 객체를 생성해 
 * 공유해 사용한다 
 */
public class ItemDAO {
	private static ItemDAO dao=new ItemDAO();
	private ItemDAO(){}
	public static ItemDAO getInstance(){
		return dao;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		closeAll(null, pstmt,con);
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,
			Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DbInfo.URL,"scott","tiger");
	}
	public void registerItem(ItemVO itemVO) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into item(item_no,name,maker,price,detail) values(item_seq.nextval,?,?,?,?)";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, itemVO.getName());
			pstmt.setString(2, itemVO.getMaker());
			pstmt.setInt(3, itemVO.getPrice());
			pstmt.setString(4, itemVO.getDetail());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<ItemVO> getAllItemList() throws SQLException{
		ArrayList<ItemVO> list=new ArrayList<ItemVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select item_no,name,maker from item order by item_no desc";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemVO vo=new ItemVO(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public ItemVO findItemByNo(String no) throws SQLException{
		ItemVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select name,maker,price,detail from item where item_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo=new ItemVO(no,rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	public void deleteItem(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from item where item_no = ?";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,no);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
}















