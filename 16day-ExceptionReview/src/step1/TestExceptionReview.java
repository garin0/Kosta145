package step1;

import java.util.Scanner;

public class TestExceptionReview {
	/*
	 * ���� ���� �̿� �ݾ��� 0�� �����̸� InvalidMoneyException�� �߻���Ű�� ȣ���� ������ �ش� Exception��
	 * �����ϴ� ����.
	 */
	public static void main(String[] args) {
		AccountService service = new AccountService();
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ա��� �ݾ��� �Է��ϼ���.");

		try {
			int money = Integer.parseInt(sc.nextLine());
			service.deposit(money);
			System.out.println("�ԱݿϷ� �� �۾�");
		} catch (NumberFormatException e) {
			System.out.println("�ݾ��� ���ڷ� �Է��ϼ���!");
		} catch (InvalidMoneyException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}

}
