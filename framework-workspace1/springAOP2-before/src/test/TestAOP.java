package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.AccountService;
import model.CardService;

public class TestAOP {
	/*
	 * 요구사항
	 * 기존 서비스(계좌서비스,카드서비스)가 제공될 때
	 * 해당 메서드 실행전에 
	 * 별도의 파일에 매개변수에 전달되는 인자값을 로깅처리
	 * 
	 * 계좌 서비스,카드 서비스 -> 핵심관심사항(core concern)
	 * 위 서비스에 로깅처리 -> 공통관심사항(cross-cutting concern or common concern)
	 * AOP 적용단계
	 * 1.공통 관심 사항을 정의 : aop.common.ParamLoggingService
	 * 							 beforeLogging(JoinPoing)
	 * 2. aop config : aop.xml
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("aop.xml");
		AccountService as = (AccountService) factory.getBean("accountService");
		CardService cs = (CardService) factory.getBean("cardService");
		as.deposit(100);
		as.register("아이유", 100);
		as.withdraw(200);
		cs.delete(1);
		cs.pay();
		cs.register(8);
		System.out.println("*****************");
		CardService cardService = new CardService();
		// IOC 방식이 아니기 때문에 AOP 적용되지 않는다.
		cardService.delete(2);
		System.out.println(cardService.getClass());
		
		// IOC 방식으로 획득한 객체를 이용하면 AOP 적용된다.
		// 즉 AOP는 IOC를 기반한다.
		// AccountService Interface type의 Proxy(대리인) 객체의 클래스
		System.out.println(as.getClass());
		as.deposit(10);
		System.out.println(cs.getClass());
		cs.delete(1);
		factory.close();
	}

}
