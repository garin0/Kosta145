package school;

import java.util.ArrayList;

import school.Person;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();

	public int findIndexByTel(String tel) {
		/*
		 * tel에 해당하는 list 요소(구성원)의 인덱스를 반환하는 메서드 만약 tel에 해당하는 요소가 없을 경우 -1 반환
		 * 추가, 검색,수정,삭제 메서드의 공통 기능을 별도의 메서드에서 처리해본다.
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
				throw new DuplicateTelException(p.getTel() + " tel이 존재하여 추가불가!");
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
				if (findIndexByTel(tel) == -1) { // 존재하지 않으면
					throw new PersonNotFoundException("찾는 사람이 없어요!");
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
					throw new PersonNotFoundException(p.getTel() + " tel이 존재하지 않아 수정할 수 없습니다.!");
				}
			}
		} finally {

		}
	}

	public void deletePersonByTel(String tel) throws PersonNotFoundException {
		try {
			for (int i = 0; i < list.size(); i++) {
				if (findIndexByTel(tel) != -1) { // 존재하면
					list.remove(findIndexByTel(tel));
					
					break;
				} else {
					throw new PersonNotFoundException("삭제할 사람이 없습니다!");
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
					throw new PersonNotFoundException(address + "에 사는 구성원이 없습니다.");
				}
			}
		} finally {

		}

		return reList;
	}
	
}
