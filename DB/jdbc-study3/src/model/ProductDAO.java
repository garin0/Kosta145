package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Data Access Object
public class ProductDAO {

	public ProductDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public ProductVO findProductById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO vo = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select name,maker,price from product where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVO(id, rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;

	}

	public void registerProduct(ProductVO pvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product(id,name,maker,pricetr");
			sql.append("values(?,?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pvo.getId());
			pstmt.setString(2, pvo.getName());
			pstmt.setString(3, pvo.getMaker());
			pstmt.setInt(4, pvo.getPrice());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<ProductVO> getProductListByPrice(int lowPrice, int highPrice) throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select id,name,maker,price from product where price >= ? and  price <= ? order by price desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lowPrice);
			pstmt.setInt(2, highPrice);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;

	}

	public ArrayList<String> getProductMakerKind() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select distinct maker from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("maker"));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<ProductVO> getProductListDiscountPrice(int percent) throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select id,name,maker,price-(price*?/100) as 할인된가격 from product order by price desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, percent);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

}
