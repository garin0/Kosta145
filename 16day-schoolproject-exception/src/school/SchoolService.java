package school;

import java.util.ArrayList;

import school.Person;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();

	public int findIndexByTel(String tel) {
		/*
		 * tel�� �ش��ϴ� list ���(������)�� �ε����� ��ȯ�ϴ� �޼��� ���� tel�� �ش��ϴ� ��Ұ� ���� ��� -1 ��ȯ
		 * �߰�, �˻�,����,���� �޼����� ���� ����� ������ �޼��忡�� ó���غ���.
		 */
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTel().equals(tel)) {
				index = i;
			}
		}
		return index;
	}

	public void addPerson(Person p) throws DuplicateTelException {
		try {
			if (findIndexByTel(p.getTel()) == -1) {
				list.add(p);

			} else {
				throw new DuplicateTelException(p.getTel() + " tel�� �����Ͽ� �߰��Ұ�!");
			}
		} finally {
		}
	}

	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public Person findPersonByTel(String tel) throws PersonNotFoundException {
		Person rePerson = null;
		try {
			for (int i = 0; i < list.size(); i++) {
				if (findIndexByTel(tel) == -1) { // �������� ������
					throw new PersonNotFoundException("ã�� ����� �����!");
				} else {
					if (findIndexByTel(tel) != -1)
						rePerson = list.get(findIndexByTel(tel));
				}
			}

		} finally {

		}
		return rePerson;
	}

	public void updatePerson(Person p) throws PersonNotFoundException {
		try {
			for (int i = 0; i < list.size(); i++) {
				if (findIndexByTel(p.getTel()) != -1) {
					list.set(findIndexByTel(p.getTel()), p);
				} else {
					throw new PersonNotFoundException(p.getTel() + " tel�� �������� �ʾ� ������ �� �����ϴ�.!");
				}
			}
		} finally {

		}
	}

	public void deletePersonByTel(String tel) throws PersonNotFoundException {
		try {
			for (int i = 0; i < list.size(); i++) {
				if (findIndexByTel(tel) != -1) { // �����ϸ�
					list.remove(findIndexByTel(tel));
					
					break;
				} else {
					throw new PersonNotFoundException("������ ����� �����ϴ�!");
				}
			}
		} finally {

		}
	}

	public ArrayList<Person> findPersonListByAddress(String address) throws PersonNotFoundException {
		ArrayList<Person> reList = new ArrayList<Person>();
		try {
			for (int i = 0; i < list.size(); i++) {
				if (address.equals(list.get(i).getAddress())) {
					reList.add(list.get(i));
				} else {
					throw new PersonNotFoundException(address + "�� ��� �������� �����ϴ�.");
				}
			}
		} finally {

		}

		return reList;
	}
	
}
