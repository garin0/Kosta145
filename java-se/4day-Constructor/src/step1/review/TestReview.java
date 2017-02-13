package step1.review; 

public class TestReview {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("æ∆¿Ã¿Ø");
		System.out.println(e.getName());
		e.setAge(24);
		System.out.println(e.getAge());
	}

}
