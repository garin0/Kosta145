package school;

import java.util.ArrayList;

import school.Person;

public class SchoolService {

	private ArrayList<Person> pList = new ArrayList<Person>();

	public void addPerson(Person p) {
		if (findPersonByTel(p.getTel()) != null) {
			System.out.println(p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!");
		} else {
			pList.add(p);
		}

	}

	public void printAll() {
		for (int i = 0; i < pList.size(); i++) {
			System.out.println(pList.get(i));
		}
	}

	public Person findPersonByTel(String tel) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getTel().equals(tel))
				return pList.get(i);
		}
		return null;
	}

	public void updatePerson(Person p) {
		boolean flag = false;
		for (int i = 0; i < pList.size(); i++) {
			if(p.getTel().equals(pList.get(i).getTel())){
				pList.set(i, p);
				flag = true;
				break;
			}

		}
		if(flag == false){
			System.out.println(p.getTel() + "��ȣ�� ���� �������� �����Ƿ� ���� �Ұ�!");
		}
	}

	public void deletePersonByTel(String tel) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getTel().equals(tel)) {
				pList.remove(i);
			}
		}

	}
}
