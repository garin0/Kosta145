package test;

import java.util.Scanner;

import school.Employee;
import school.Person;
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
				service.addPerson(new Student(tel, name, address, stuId));
			} else if (num == 2) {
				System.out.println("4. 과목을 입력하세요!");
				String subject = s.nextLine();
				service.addPerson(new Teacher(tel, name, address, subject));
			} else if (num == 3) {
				System.out.println("4. 부서를 입력하세요!");
				String dept = s.nextLine();
				service.addPerson(new Employee(tel, name, address, dept));
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
		service.deletePersonByTel(tel);
		System.out.println(tel + "delete ok!");
	}

	public static void main(String[] args) {



	}

}
