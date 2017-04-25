package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Ticket;

/*
 * Test: 기존 제어 방식에서
 * TestIOC :IOC를 적용하여 결합도를 낮추는 형태로
 * 변경해보는 예제
 */
public class TestIOC {

	public static void main(String[] args) {
		// Spring IOC Container 객체: 시작시에 ioc.xml을 로딩한다.
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		// 구체적인 항공사와는 관계없이 추상화된
		// 인터페이스 타입으로만 받아서 이용하면 된다.
		// 항공사가 변경되어도 기존 소스 코드 수정은 필요 없다.
		/*
		 * TestIOC(사용자) 측과 티켓 측의 결합도는 낮아지므로
		 * 유지보수성이 향상된다.
		 */
		Ticket ticket = (Ticket) factory.getBean("ticket"); // DL 방식의 ioc
		//Spring IOC Container는 Singleton 방식으로 객체를 운용한다.(기본)
		System.out.println(factory.getBean("ticket"));
		System.out.println(factory.getBean("ticket"));
		System.out.println(factory.getBean("ticket"));
		ticket.ticketing();
		factory.close();
	}

}
