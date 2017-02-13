package school;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class SchoolService {
	LinkedHashMap<String, Person> map = new LinkedHashMap<String, Person>();

	public void addPerson(Person p) {
		if (map.containsKey(p.getTel())) {
			System.out.println(p.getTel() + "��ȣ �����ؼ� �߰� �Ұ�");
		} else {
			map.put(p.getTel(), p);
		}
	}

	public void printAll() {
		Iterator<Person> it = map.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public Person findPersonByTel(String tel) {
		return map.get(tel);
	}

	public void updatePerson(Person p) {
		if (map.containsKey(p.getTel())) {
			map.put(p.getTel(), p);
		} else {
			System.out.println(p.getTel() + " ��ü�� ���� ������ �����Ƿ� �߰� �Ұ�");
		}
	}

	public void deletePersonByTel(String tel) {
			map.remove(tel);
	}
	
}
