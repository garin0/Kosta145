package test.timecheck;

import org.springframework.util.StopWatch;

/*
 * spring framework에서 제공하는 StopWatch를 이용해 시간체크하는 예제
 */
public class TestStopWatch {
	public void getAllList(){
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("메서드 시작");
		try {
			Thread.sleep(1900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("전체 목록 조회하여 반환");
		sw.stop();
		System.out.println(sw.getTotalTimeMillis());
	}
	public static void main(String[] args) {
		new TestStopWatch().getAllList();
	}
}
