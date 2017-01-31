package school;

public class Student extends Person{
	private String stuId;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Student(String tel, String name, String address, String stuId) {
		super(tel, name, address);
		this.stuId = stuId;
	}
	@Override
	public String toString() {
		return "tel:" + getTel() + ", name:" + getName() + ", address:" + getAddress() + ", stuId: "+ getStuId();
	}
	
}
