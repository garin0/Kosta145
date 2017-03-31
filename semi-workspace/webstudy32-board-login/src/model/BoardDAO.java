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
	public int writeBoard(BoardVO bvo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con = getConnection();
		int nextNo = 0;
		try{
			String sql ="select login_board_seq.nextval from dual";
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
			String sql="insert into login_board(no,title,content,time_posted,id)"+
						"values(?,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, nextNo);
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getContent());
			pstmt.setString(4, bvo.getId());
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
		return nextNo;
	}
	
	public int getTotalContent() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = 0;
		try{
			con=getConnection();
			String sql="select count(*) from login_board";
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
	public ArrayList<BoardVO> getAllBoardList(PagingBean pb) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try{
			con=getConnection();
			String sql ="select m.id,m.name, A.*  from(select row_number() over(order by no desc) as rnum,no,title,content,hits,"
               + "to_char(time_posted,'yyyy.MM.DD'), id "
               + "from login_board) A, login_member m where m.id=A.id and rnum between ? and ? order by no desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pb.getStartRowNumber());
			pstmt.setInt(2, pb.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(4));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(5));
				vo.setTimePosted(rs.getString(8));
				vo.setHits(rs.getInt(7));
				list.add(vo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public void updateHit(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update login_board set hits=hits+1 where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
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
			String sql="select title,to_char(time_posted,'YYYY/MM/DD HH24:MI:SS'),hits,content,id from login_board where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				vo = new BoardVO();
				vo.setTitle(rs.getString(1));
				vo.setTimePosted(rs.getString(2));
				vo.setHits(rs.getInt(3));
				vo.setContent(rs.getString(4));
				vo.setId(rs.getString(5));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	public void deletePosting(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="delete from login_board where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
	}
	public void updatePosting(BoardVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update login_board set title=?,content=? where no =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			pstmt.executeUpdate();
		}finally{
			closeAll(pstmt, con);
		}
	}
}
