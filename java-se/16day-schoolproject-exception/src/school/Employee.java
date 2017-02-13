package school;


public class Employee extends Person {
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(String tel, String name, String address, String dept) {
		super(tel, name, address);
		this.dept = dept;
		System.out.println("리스트에 추가: " + toString());
	}
	@Override
	public String toString() {
		return "Employee stuId: "+ getDept()+ ", address:" + getAddress()+", name:" + getName()+", tel:" + getTel();
	}

}
