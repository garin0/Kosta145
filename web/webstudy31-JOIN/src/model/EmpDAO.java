package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class EmpDAO {
	private static EmpDAO dao=new EmpDAO();
	private DataSource dataSource;
	private EmpDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static EmpDAO getInstance(){		
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
	
	public ArrayList<EmpVO> getAllEmpList() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try{
			con=getConnection();
			String sql ="select e.empno,e.ename,d.dname,d.loc from emp_ex e, dept_ex d where e.deptno = d.deptno order by e.empno desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				DeptVO dvo = new DeptVO(rs.getString("dname"), rs.getString("loc"));
				EmpVO vo = new EmpVO(rs.getString("empno"), rs.getString("ename"), dvo);
				list.add(vo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public ArrayList<EmpVO> getDetailEmpList(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try{
			con=getConnection();
			String sql ="select e.empno,e.ename,e.sal,d.deptno,d.dname,d.loc,d.tel from emp_ex e, dept_ex d where e.deptno = d.deptno and e.empno =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				DeptVO dvo = new DeptVO(rs.getString("deptno"),rs.getString("dname"), rs.getString("loc"),rs.getString("tel"));
				EmpVO vo = new EmpVO(rs.getString("empno"), rs.getString("ename"),rs.getInt("sal"), dvo);
				list.add(vo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
