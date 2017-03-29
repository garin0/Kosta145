package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

public class CompanyDAO {
 // getEmpNoList(): ArrayList<String>
 // getEmpAndDeptInfo(no) : HashMap<String,String>;
	private static CompanyDAO instance = new CompanyDAO();
	private DataSource dataSource;
	private CompanyDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static CompanyDAO getInstance(){
		return instance;
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
	/**
	 * 사원번호 리스트를 제공한다.
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<String> getEmpNoList() throws SQLException{
		ArrayList<String> list =new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql ="select empno from EMP_EX order by empno asc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int no = rs.getInt(1);
				list.add(Integer.toString(no));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;

	}
	/**
	 * 사원번호로 사원과 사원의 부서정보를 조회하여 map으로 제공한다.
	 * @param empNo
	 * @return
	 * @throws SQLException 
	 */
	public HashMap<String, String> getEmpAndDeptInfo(String empNo) throws SQLException{
		HashMap<String, String> map =new HashMap<String,String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql ="select e.ename,e.sal,d.dname,d.loc from( select empno,ename,sal,deptno from EMP_EX) e, DEPT_EX d where e.deptno = d.deptno and e.empno = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, empNo);
			rs=pstmt.executeQuery();
			while(rs.next()){
				map.put("ename",rs.getString(1));
				map.put("sal", rs.getString(2));
				map.put("dname", rs.getString(3));
				map.put("loc", rs.getString(4));
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return map;
	}
}
