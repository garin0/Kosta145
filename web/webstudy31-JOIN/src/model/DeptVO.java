package model;

public class DeptVO {
	private String deptno;
	private String dname;
	private String loc;
	private String tel;
	public DeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeptVO(String deptno, String dname, String loc, String tel) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.tel = tel;
	}

	public DeptVO(String dname, String loc) {
		this.dname = dname;
		this.loc = loc;
	}

	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "DeptVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", tel=" + tel + "]";
	}
	
}
