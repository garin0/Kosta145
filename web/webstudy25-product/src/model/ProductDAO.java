package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	private DataSource dataSource;
	// 외부에서 생성 못하게 private 처리
	private ProductDAO(){
		dataSource =DataSourceManager.getInstance().getDataSource();
	}
	//외부에 현 객체 레퍼런스를 공유
	public static ProductDAO getInstance(){
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
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		closeAll(null, pstmt,con);
	}
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection(); //커넥션을 빌려온다.
	}
	
	public void registerProduct(ProductVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into product(product_no,name,maker,price,reg_date) values(product_seq.nextval,?,?,?,sysdate)";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMaker());
			pstmt.setInt(3, vo.getPrice());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<ProductVO> getAllProductList() throws SQLException{
		ArrayList<ProductVO> list=new ArrayList<ProductVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select product_no,name,to_char(reg_date,'YYYY/MM/DD') from product order by product_no desc";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ProductVO vo= new ProductVO(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public ProductVO findProductByNo(int no) throws SQLException{
		ProductVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select product_no,name,maker,price,to_char(reg_date,'YYYY/MM/DD HH24:MI:SS') from product where product_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo = new ProductVO(no,rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	public void deleteProduct(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from product where product_no = ?";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,no);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
}
