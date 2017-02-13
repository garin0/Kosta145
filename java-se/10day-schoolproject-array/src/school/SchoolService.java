package school;

public class SchoolService {
	Person[] personList;
	private int index = 0;

	public SchoolService(int num) {
		personList = new Person[num];
	}

	public void addPerson(Person p) {
		if (findPersonByTel(p.getTel()) != null) {
			System.out.println(p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!");
		} else {
			personList[index++] = p;
		}
	}

	public void printAll() {
		for (int i = 0; i < index; i++) {
			System.out.println(personList[i]);
		}

	}

	public Person findPersonByTel(String findTel) {
		for (int i = 0; i < index; i++) {
			if (personList[i].getTel().equals(findTel))
				return personList[i];
		}
		return null;
	}

	public void updatePerson(Person p) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (p.getTel().equals(personList[i].getTel())) {
				personList[i] = p;
				flag = true;
				break;
			}
		}
		if (flag == false)
			System.out.println(p.getTel() + "��ȣ�� ���� �������� �����Ƿ� ���� �Ұ�!");
	}

	public void deletePersonByTel(String delTel) {
		for (int i = 0; i < index; i++) {
			if (personList[i].getTel().equals(delTel)) {
				for (int j = i; j < index - 1; j++) {
					personList[j] = personList[j + 1];
				}
				index--;

			}
		}
	}

}
