package step6;

import java.util.Date;

import step4.Car;
import step5.MemberVO;

public class TestImport {

	public static void main(String[] args) {
		MemberVO mvo = new MemberVO("ktx","아이유");
		System.out.println(mvo.getId() + " " + mvo.getName());
		
		Car c  = new Car("아우디");
		System.out.println(c.getModel());
		
		Date d = new Date();
		System.out.println(d.toString());
	}

}
