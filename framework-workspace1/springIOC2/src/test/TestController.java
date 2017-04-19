package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BankService;

// 사용자: model 계층을 이용하는 컨트롤러로 가정
/*					스프링컨테이너 -- ioc.xml
 * 사용자							  model
 * TestController						Service	 DAO
 * ioc.xml에서 스프링컨테이너에게 kbDAOImpl 객체를 생성하고
 * 생성한 kbDAOImpl 객체를 BankServiceImpl 생성시
 * 생성자에 주입(DI)하게 설정한다.
 * 
 * 사용자 측인 TestController는 bankService id로 검색(DL)하여
 * BankService 인터페이스 타입인
 * BankServiceImpl 객체를 반환받아 사용하도록 설정한다.
 */
public class TestController {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		BankService service =(BankService) factory.getBean("bankService");
		service.deposit(100);
		factory.close();
	}

}
