package test;

import model.MemberService;
import model.ProductService;

public class Test {
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
	 * @param args
	 */
	public static void main(String[] args) {
		MemberService ms = new MemberService();
		ms.findMemberById();
		ms.registerMember();
		ms.selectMemberList();
		ProductService ps = new ProductService();
		ps.deleteProduct();
		ps.findProductById();
	}
}
