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
	public ArrayList<BoardVO> getAllBoardList(PagingBean pb) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try{
			con=getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select A.* from (");
			sql.append("select row_number() over(order by no desc)");
			sql.append("as rnum,no,title,writer,to_char(time_posted,'YYYY/MM/DD')");
			sql.append(" as time_posted,hit from board");
			sql.append(")A  where rnum between ? and ?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pb.getStartRowNumber());
			pstmt.setInt(2, pb.getEndRowNumber());
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setTimePosted(rs.getString("time_posted"));
				vo.setHits(rs.getInt("hit"));
				list.add(vo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public int writeBoard(BoardVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con = getConnection();
		int nextNo = 0;
		try{
			String sql ="select board_seq.nextval from dual";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				nextNo = rs.getInt(1);
			}
		}finally{
			con.close();
		}
		try{
			con=getConnection();
			String sql="insert into board(no,title,writer,password,content,time_posted)"+
						"values(?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, nextNo);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getPassword());
			pstmt.setString(5, vo.getContent());
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
		return nextNo;
	}
	public BoardVO findBoardByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardVO vo = null;
		try{
			con=getConnection();
			String sql="select title,writer,to_char(time_posted,'YYYY/MM/DD HH24:MI:SS'),hit,content from board where no = ?";
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
	
	public void updateHit(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update board set hit=hit+1 where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
	}
	public void deletePosting(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="delete from board where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
	}
	public void updateData(BoardVO vo,int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update board set writer=?,title=?,content=? where no =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, no);
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
	}
	
	public boolean checkPassword(int no, String password) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			con=getConnection(); 
			String sql="select count(*) from board where no=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)!=0)
					flag=true;
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return flag;
	}
	
	public int getTotalContent() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = 0;
		try{
			con=getConnection();
			String sql="select count(*) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
		}finally{
			closeAll(pstmt, con);
		}
		return result;
	}
	
	
}
