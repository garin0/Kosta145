package test;

import java.util.Scanner;

import school.DuplicateTelException;
import school.Employee;
import school.Person;
import school.PersonNotFoundException;
import school.SchoolService;
import school.Student;
import school.Teacher;

public class ConsoleUI {
static SchoolService service = new SchoolService();

public static void addPerson(int num) {

	Scanner s = new Scanner(System.in);
	if (num >= 1 && num <= 3) {
		System.out.println("1.전화번호를 입력하세요!");
	String tel = s.nextLine();
	System.out.println("2. 이름을 입력하세요!");
	String name = s.nextLine();
	System.out.println("3. 주소를 입력하세요!");
	String address = s.nextLine();

	if (num == 1) {
		System.out.println("4. 학번을 입력하세요!");
		String stuId = s.nextLine();
		try {
			service.addPerson(new Student(tel, name, address, stuId));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}

	} else if (num == 2) {
		System.out.println("4. 과목을 입력하세요!");
		String subject = s.nextLine();
		try {
			service.addPerson(new Teacher(tel, name, address, subject));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	} else if (num == 3) {
		System.out.println("4. 부서를 입력하세요!");
		String dept = s.nextLine();
		try {
			service.addPerson(new Employee(tel, name, address, dept));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}
} else {
	System.out.println("1~3까지의 수만 입력해주세요.");
	}

}

static public void printAll() {
	System.out.println("**전체구성원보기**");
	service.printAll();
}

static public void deletePerson() {
	Scanner s = new Scanner(System.in);
	System.out.println("삭제할 구성원의 전화번호를 입력하세요");
String tel = s.nextLine();
try {
	service.deletePersonByTel(tel);
	System.out.println(tel+ "delete ok!");
	} catch (PersonNotFoundException e) {
		System.out.println(e.getMessage());
	}
	
}

public static void FindPerson(){
	Person rp;
	Scanner s = new Scanner(System.in);
	System.out.println("검색할 구성원의 전화번호를 입력하세요");
		String tel = s.nextLine();
		try{
			rp = service.findPersonByTel(tel);
			System.out.println(rp);
		}catch(PersonNotFoundException e){
			System.out.println(e.getMessage());
		}

	}
	

}
