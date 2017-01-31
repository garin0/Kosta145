package step5;

public class TestEncapsulation {

	public static void main(String[] args) {
		Account a = new Account();
		// money는 private으로 선언되어 접근불가
		// System.out.println(a.money);
		// setter에 접근하여 정보를 할당한다.
		a.setMoney(100);
		System.out.println(a.getMoney());
		
		a.setName("suzy");
		System.out.println(a.getName()); //suzy
	}
}
