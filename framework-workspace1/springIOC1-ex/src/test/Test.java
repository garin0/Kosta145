package test;

import model.AsianaTicket;

public class Test {

	public static void main(String[] args) {
		/* 기존 제어 방식: 필요한 측에서 대상을 
		 * 생성 또는 확보해서 사용한다
		 * Test(사용자) --new--> KalTicket()
		 * 만약 대한항공에서 아시아나항공으로 변경해야 한다면
		 * 아래 코드를 수정해야 한다.
		 * 
		 * 사용하는 Test측과 구체적인 티켓 측은
		 * 결합도가 높다.
		 * -> 결합도를 낮추기 위해 IOC를 적용해 본다.
		 * 	--> IOC를 적용하기 위해 Spring Framework의
		 * 		IOC 컨테이너를 이용한다.
		 * 		--> Spring Framework가 동작되는 데 필요한 환경을 설정한다.
		 * 		  --> 1. eclipse에서 sts 설치
		 * 			  2. spring ioc container가 동작되기 위한 spring library를 확보해야 한다.
		 * 			  3. spring ioc container의 환경설정정보를 작성해야 한다.
		 */
//		KalTicket ticket = new KalTicket();
		AsianaTicket ticket = new AsianaTicket();
		ticket.ticketing();
	}

}
