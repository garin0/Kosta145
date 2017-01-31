package step1.review;

public class TestReview {

	public static void main(String[] args) {
		// 반복문 for
		for (int i = 0; i < 5; i++) {
			System.out.println(i);

		}
		System.out.println("*******************");
		// 반복문 while
		int j = 0;
		while (j < 5) {
			System.out.println(j);
			j++;
		}
		System.out.println("*******************");
		// do while : 조건에 맞지 않더라도 한번 수행
		int k = 0;
		do {
			System.out.println(k);
			k++;
		} while (k < 0);
	}

}
