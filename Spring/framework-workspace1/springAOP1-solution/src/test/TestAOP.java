package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;
import model.ProductService;
/**
 * 현 시스템의 model 팩키지 이하에 있는 모든
 * 클래스의 모든 메서드가 실행하기 전에
 * 특정 파일에 실행되는 시간을 기록(로깅)하라는
 * 요구사항이 있다.
 * 
 * 방안1 오픈소스라이브러리인 Log4J를 이용하는 방안
 * 
 *	model
 *			MemberService <-- import	Log4J
 *			ProductService
 *
 * log info level로 java-kosta 이하에 project.log에 로깅처리
 * 
 * maven pom.xml
 * log4j.xml
 * model 이하 클래스의 각 메서드 시작시점에 로깅처리
 * 
 * 시스템의 규모가 클수록 작업량은 늘어난다.
 * --> 요구사항에 대한 처리 작업을
 * 	   효과적으로 구현하고 유지보수할 수 있는 방안
 * 	   --> AOP(Aspect Oriented Programming)
 * 
 * 방안 2. AOP를 적용한다
 * Aspect Oriented Programming은 시스템을 핵심관심사항과 공통(횡단)관심사항으로 구분하여
 * 공통관심사항에 대한 작업을 별도의 모듈에서 처리하도록 한다.
 * -> 기존 소스코드를 수정하지 않고 별도의 모듈에서 한번 구현하고
 * 유지보수하므로 생산성 및 유지보수성을 향상시킬 수 있다.
 * 
 * how?
 * 	0. maven: aop library 추가
 * 	1. 공통관심사항을 정의하는 클래스를 구현
 * 	2. spring config(xml)에서 AOP 설정
 * @param args
 */
public class TestAOP {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("aop.xml");
		MemberService ms = (MemberService) factory.getBean("memberService");
		ProductService ps = (ProductService) factory.getBean("productService");
		ms.findMemberById();
		ms.registerMember();
		ms.selectMemberList();
		ps.deleteProduct();
		ps.findProductById();
		factory.close();
	}

}
