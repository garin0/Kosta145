package step3;

public class TestException4 {

	public static void main(String[] args) {
		String names[] = { "����", "������", "�����" };
		try {
			// System.out.println(names[2]);
			System.out.println(names[3]);
			System.out.println("�Ұ���");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("catch������ ����� �����Ѵ�.");
		}
		System.out.println("���α׷� ���� ���� �� ����");
	}

}
