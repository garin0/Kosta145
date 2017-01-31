package test;
import java.util.Scanner;

import school.PersonNotFoundException;

public class TestSchool {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*******학사관리프로그램을 시작합니다******");

		while (true) {
			System.out.println("1. 추가 2. 삭제 3. 검색 4. 전체회원보기 5.종료");
			int select = sc.nextInt();
			String tel;
			switch (select) {
			case 1: // 추가
				System.out.println("입력할 구성원의 종류를 선택하세요 1.학생  2.선생님 3.직원");
				int num = sc.nextInt();
				ConsoleUI.addPerson(num);
				break;
			case 2: // 삭제
				ConsoleUI.deletePerson();
				break;
			case 3: // 검색
				ConsoleUI.FindPerson();
				break;
			case 4: // 전체회원보기
				ConsoleUI.printAll();
				break;
			case 5: // 종료
				System.out.println("*******학사관리프로그램을 종료합니다******");
				return;
			default:
			}
		}

	}

}
