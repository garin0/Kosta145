package model;

public class EmpVO {
	
	private String empno;
	private String ename;
	private int salary;
	private DeptVO deptVO;
	public EmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpVO(String empno, String ename, int salary, DeptVO deptVO) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.deptVO = deptVO;
	}
	
	public EmpVO(String empno, String ename,String dname,String loc){
		super();
		this.empno = empno;
		this.ename = ename;
		getDeptVO().setDname(dname);
		getDeptVO().setLoc(loc);
	}
	public EmpVO(String empno, String ename, DeptVO deptVO) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptVO = deptVO;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public DeptVO getDeptVO() {
		return deptVO;
	}
	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}
	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", deptVO=" + deptVO + "]";
	}
	
}
