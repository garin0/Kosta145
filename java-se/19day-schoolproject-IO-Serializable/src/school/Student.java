package school;

public class Student extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4523454124772391235L;
	private String stuId;
	public Student(String tel, String name, String address, String stuId) {
		super(tel, name, address);
		this.stuId = stuId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	@Override
	public String toString() {
		return super.toString()+" stuId=" + stuId;
	}	
}







