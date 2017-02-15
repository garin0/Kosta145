package step2;

import java.util.ArrayList;

public class TestList2 {

	public static void main(String[] args) {
		/*
		 * ArrayList list = new ArrayList(); list.add(new Person("�����",30)); //
		 * list�� ù��° ����� ���̸� ��� // Object type���� ��ȯ�ǹǷ� Object casting �ؾ�
		 * getAge()�� ȣ���� �� �ִ�. Person p = ((Person) list.get(0));
		 * System.out.println(p.getAge()); list.add(new Person("������", 26));
		 * list.add(new Person("�輭��", 24)); // for�� �̿��ؼ� list�� ��� ����� name��
		 * ����Ѵ�. for(int i = 0 ; i < list.size() ; i++){ Person pl = (Person)
		 * list.get(i); System.out.println(pl.getName()); }
		 */

		// �� �ڵ带 Generic�� �����ϸ� �Ʒ��� ����.
		ArrayList<Person> genericList = new ArrayList<Person>();
		genericList.add(new Person("������", 24));
		genericList.add(new Person("�����", 30));
		// ù��° ����� �̸��� ��ȯ�޾� ���
		// (Generic ���������Ƿ� ������ ĳ���� ���� �ʿ����)
		System.out.println(genericList.get(0).getName());
		genericList.add(new Person("������", 32));
		System.out.println("-------------------");
		// for���� �̿��� 30�� �̻� Person�� �̸� ���
		for (int i = 0; i < genericList.size(); i++) {
			if (genericList.get(i).getAge() >= 30) {
				System.out.println(genericList.get(i).getName());
			}
		}

	}

}