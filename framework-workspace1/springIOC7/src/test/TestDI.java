package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Residence;

public class TestDI {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("di.xml");
		Residence r1 =(Residence) ctx.getBean("hotel");
		r1.reside();//힐튼 30만원
		
		Residence r2=(Residence)ctx.getBean("dormitory");
	    r2.reside();
	    
	    Residence r3=(Residence)ctx.getBean("house");
	    r3.reside();
	    /* 실행결과
	    힐튼 30만원
	    학교명:판교대학교 서고:[Book [title=웹2.0경제학, writer=김국현], Book [title=새로운미래가온다, writer=다니엘핑크]]
	    판교자이 {tv=HomeAppliance [maker=삼성, productName=파브], washing=HomeAppliance [maker=LG, productName= 세탁기]*/
		ctx.close();
	}

}
