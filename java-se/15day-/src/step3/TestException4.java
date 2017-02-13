package step3;

public class TestException4 {

	public static void main(String[] args) {
		String names[] = { "설현", "윤다혜", "김규익" };
		try {
			// System.out.println(names[2]);
			System.out.println(names[3]);
			System.out.println("소개팅");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("catch문으로 대안을 실행한다.");
		}
		System.out.println("프로그램 정상 수행 후 종료");
	}

}
