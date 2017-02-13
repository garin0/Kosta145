package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {

	public MemoDAO() throws ClassNotFoundException {
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

	public void insertMemo(MemoVO memoVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "insert into memo(memo_no,title,content) values(memo_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memoVO.getTitle());
			pstmt.setString(2, memoVO.getContent());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<MemoVO> getAllMemoList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemoVO> list = new ArrayList<MemoVO>();
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String sql = "select memo_no,title,content from memo order by memo_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemoVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

}
