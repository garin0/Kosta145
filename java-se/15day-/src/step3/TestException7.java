package step3;

import java.util.Scanner;

public class TestException7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("����� ���̸� �Է��ϼ���(����)");
		String str = sc.nextLine();
		try {
			int age = Integer.parseInt(str);
			age = age + 1;
			System.out.println("����� ���̴�: " + str);
		} catch (NumberFormatException e) {
			System.out.println("���� �Է����ּ���");
		} finally {
			sc.close();
		}
		// System.out.println("233");
	}

}
