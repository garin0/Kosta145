package model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberService {
	private Log log = LogFactory.getLog(getClass());
	public void registerMember(){
		log.info("실행");
		System.out.println("registerMember");
	}
	public void findMemberById(){
		log.info("실행");
		System.out.println("findMemberById");
	}
	public void selectMemberList(){
		log.info("실행");
		System.out.println("selectMemberList");
	}
	// 그 외 여러 메서드가 있다고 가정한다.
}
