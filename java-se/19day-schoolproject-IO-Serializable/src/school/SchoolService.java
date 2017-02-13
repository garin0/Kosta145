package school;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolService {

	private ArrayList<Person> list = new ArrayList<Person>();
	private String path = "C:\\java-kosta\\test\\school\\PersonList.obj";
	
	@SuppressWarnings("unchecked")
	public void loadData() throws  IOException, ClassNotFoundException{
		//저장 디렉토리가 존재하지 않으면 생성한다 
		File saveDir=new File(path).getParentFile();
		if(saveDir.isDirectory()==false)
			saveDir.mkdirs();
		//저장된 파일의 존재 유무를 확인해 없으면 역직렬화하지 않고
		//존재하면 역직렬화하여 list에 할당한다. 
		File saveFile=new File(path);
		if(saveFile.isFile()){
			ObjectInputStream ois=new ObjectInputStream(
					new FileInputStream(path));
			list=(ArrayList<Person>)ois.readObject();
			ois.close();
		}
	}
	
	public void saveData() throws  IOException{
		ObjectOutputStream oos=new ObjectOutputStream(
				new FileOutputStream(path));
		oos.writeObject(list);
		oos.close();
	}

	/*
	 * tel 에 해당하는 list 요소(구성원)의 인덱스를 반환하는 메서드 만약 tel 에 해당하는 요소가 없을 경우 -1 을 반환
	 * 추가,검색,수정,삭제 메서드의 공통 기능을 별도의 메서드에서 처리해본다
	 */
	public int findIndexByTel(String tel) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (tel.equals(list.get(i).getTel())) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void addPerson(Person p) throws DuplicateTelException, FileNotFoundException, ClassNotFoundException, IOException {
		if (findIndexByTel(p.getTel()) != -1)
			throw new DuplicateTelException(p.getTel() + " tel이 존재하여 추가불가!");
		list.add(p);
	}

	public void printAll() {
		Iterator<Person> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

	public Person findPersonByTel(String tel) throws PersonNotFoundException {
		int index = findIndexByTel(tel);
		if (index == -1)
			throw new PersonNotFoundException(tel + " tel이 존재하지 않아 조회할 수 없습니다.!");
		return list.get(index);
	}

	public void updatePerson(Person p) throws PersonNotFoundException {
		int index = findIndexByTel(p.getTel());
		if (index == -1)
			throw new PersonNotFoundException(p.getTel() + " tel이 존재하지 않아 수정할 수 없습니다.!");
		list.set(index, p);
	}

	public void deletePersonByTel(String tel) throws PersonNotFoundException {
		int index = findIndexByTel(tel);
		if (index == -1)
			throw new PersonNotFoundException(tel + " tel이 존재하지 않아 삭제할 수 없습니다.!");
		list.remove(index);
	}
}
