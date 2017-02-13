package step5;

public class TestConstructor3 {

	public static void main(String[] args) {
		MemberVO mvo = new MemberVO("javaking","아이유");
		System.out.println(mvo.getId());
		System.out.println(mvo.getName());
		mvo.setId("javastar");
		mvo.setName("장기하");
		System.out.println(mvo.getId() + " " +mvo.getName());
		
	}

}
