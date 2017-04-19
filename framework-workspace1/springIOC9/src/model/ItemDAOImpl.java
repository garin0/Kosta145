package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ItemDAOImpl implements ItemDAO {
	private DataSource dataSource;
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		closeAll(null, pstmt,con);
	}
	public ItemDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	public Connection getConnection() throws SQLException {
		Connection con = dataSource.getConnection();
		return con;
	}
	
	@Override
	public ArrayList<ItemVO> getItemListByMaker(String maker) throws SQLException{
		ArrayList<ItemVO> list=new ArrayList<ItemVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select name,maker,price,detail from item where maker = ?";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, maker);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemVO vo= new ItemVO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	@Override
	public int getAvgPriceByMaker(String maker) throws SQLException{
		int avgPrice = 0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select avg(price) from item where maker = ?";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, maker);
			rs=pstmt.executeQuery();
			while(rs.next()){
				avgPrice = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return avgPrice;
	}
}
