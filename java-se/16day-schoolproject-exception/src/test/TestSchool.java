package test;
import java.util.Scanner;

import school.PersonNotFoundException;

public class TestSchool {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*******�л�������α׷��� �����մϴ�******");

		while (true) {
			System.out.println("1. �߰� 2. ���� 3. �˻� 4. ��üȸ������ 5.����");
			int select = sc.nextInt();
			String tel;
			switch (select) {
			case 1: // �߰�
				System.out.println("�Է��� �������� ������ �����ϼ��� 1.�л�  2.������ 3.����");
				int num = sc.nextInt();
				ConsoleUI.addPerson(num);
				break;
			case 2: // ����
				ConsoleUI.deletePerson();
				break;
			case 3: // �˻�
				ConsoleUI.FindPerson();
				break;
			case 4: // ��üȸ������
				ConsoleUI.printAll();
				break;
			case 5: // ����
				System.out.println("*******�л�������α׷��� �����մϴ�******");
				return;
			default:
			}
		}

	}

}
