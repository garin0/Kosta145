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
		System.out.println("리스트에 추가: " + toString());
	}
	@Override
	public String toString() {
		return "Student stuId: "+ getStuId()+ ", address:" + getAddress()+", name:" + getName()+", tel:" + getTel();
	}
	
}
