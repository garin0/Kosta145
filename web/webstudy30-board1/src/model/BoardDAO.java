package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO dao=new BoardDAO();
	private DataSource dataSource;
	private BoardDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance(){		
		return dao;
	}
	public void closeAll(PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		closeAll(pstmt,con);
	}
	private Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	public ArrayList<BoardVO> getAllBoardList() throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try{
			con=getConnection();
			String sql="select no,title,writer,to_char(time_posted,'YYYY/MM/DD'),hit from board order by no desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public void writeBoard(BoardVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="insert into board(no,title,writer,password,content,time_posted)"+
						"values(board_seq.nextval,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
		
		
	}
	public BoardVO findBoardByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardVO vo = null;
		try{
			con=getConnection();
			String sql="select title,writer,to_char(time_posted,'YYYY/MM/DD'),hit,content from board where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				vo  =  new BoardVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),no);
			}
			
		}finally{
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
}
