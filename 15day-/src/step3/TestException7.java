package step3;

import java.util.Scanner;

public class TestException7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 나이를 입력하세요(숫자)");
		String str = sc.nextLine();
		try {
			int age = Integer.parseInt(str);
			age = age + 1;
			System.out.println("당신의 나이는: " + str);
		} catch (NumberFormatException e) {
			System.out.println("숫자 입력해주세요");
		} finally {
			sc.close();
		}
		// System.out.println("233");
	}

}
