package school;

public class Teacher extends Person {
	private String subject;

	public Teacher(String tel, String name, String address, String subject) {
		super(tel, name, address);
		this.subject = subject;
		System.out.println("����Ʈ�� �߰�: " + toString());
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Teacher stuId: "+ getSubject()+ ", address:" + getAddress()+", name:" + getName()+", tel:" + getTel();
	}
}
