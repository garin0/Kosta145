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
		System.out.println("1.��ȭ��ȣ�� �Է��ϼ���!");
	String tel = s.nextLine();
	System.out.println("2. �̸��� �Է��ϼ���!");
	String name = s.nextLine();
	System.out.println("3. �ּҸ� �Է��ϼ���!");
	String address = s.nextLine();

	if (num == 1) {
		System.out.println("4. �й��� �Է��ϼ���!");
		String stuId = s.nextLine();
		try {
			service.addPerson(new Student(tel, name, address, stuId));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}

	} else if (num == 2) {
		System.out.println("4. ������ �Է��ϼ���!");
		String subject = s.nextLine();
		try {
			service.addPerson(new Teacher(tel, name, address, subject));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	} else if (num == 3) {
		System.out.println("4. �μ��� �Է��ϼ���!");
		String dept = s.nextLine();
		try {
			service.addPerson(new Employee(tel, name, address, dept));
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}
} else {
	System.out.println("1~3������ ���� �Է����ּ���.");
	}

}

static public void printAll() {
	System.out.println("**��ü����������**");
	service.printAll();
}

static public void deletePerson() {
	Scanner s = new Scanner(System.in);
	System.out.println("������ �������� ��ȭ��ȣ�� �Է��ϼ���");
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
	System.out.println("�˻��� �������� ��ȭ��ȣ�� �Է��ϼ���");
		String tel = s.nextLine();
		try{
			rp = service.findPersonByTel(tel);
			System.out.println(rp);
		}catch(PersonNotFoundException e){
			System.out.println(e.getMessage());
		}

	}
	

}
