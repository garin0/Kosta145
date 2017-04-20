package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.model.board.BoardService;
import kosta.model.member.MemberDao;
import kosta.model.member.MemberService;
/**
 * 현 시스템에서 대상 메서드 실행 전에 log.debug를 실행하는
 * 공통 기능 구현
 * -> log.debug에서 대상 클래스명 메서드명을 로깅
 * 
 * 적용대상: kosta.model 이하의 모든 하위 패키지의
 * 모든 클래스들 중 접근제어자는 public이고
 * 리턴 타입은 String , 메서드명은 select로 시작
 * 매개변수는 0~*
 * 
 * advice(적용시점):before advice
 * pointcut(적용대상):execution(aspectj 표현식)
 * 공통 관심사항 정의 클래스 : kosta.common.LoggingService
 * 							 : testLog(JoinPoint)
 * ----------------------------------------------------------
 * 요구사항 수정
 * 적용시점(advice) : 메서드 실행 후 리턴되는 시점에 공통기능 적용
 * 					  after-returning advice로 변경
 * @author KOSTA
 *
 */
public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx
		  =new ClassPathXmlApplicationContext("aop.xml");
		  BoardService bs=(BoardService) ctx.getBean("boardService");
		  bs.insertContent();
		  System.out.println(bs.selectContent("a"));
		  MemberService ms=(MemberService) ctx.getBean("memberService");
		  System.out.println(ms.selectAddress());
		  System.out.println(ms.selectAge());
		  MemberDao md=(MemberDao)ctx.getBean("memberDao");
		  System.out.println(md.selectPassword());
		  ctx.close();
	}

}
