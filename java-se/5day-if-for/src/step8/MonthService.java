package step8;

public class MonthService {

	public void printLastDay(int month) {
		switch(month){
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println(month + "월의 마지막 일은 31일입니다");
			break;
		case 2:
			System.out.println(month + "월의 마지막 일은 28일입니다");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월의 마지막 일은 30일입니다");
			break;
		default:
			System.out.println("잘못된 입력값입니다.");
			
		}
	}

}
