package step4;

/* 채팅 클라이언트
 * 나의 메세지를 서버로 출력 (출력 스레드)
 * 친구들의 메세지를 입력 (입력 스레드)
 */
class OutputWorker implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("입력 스레드 실행 " + i);
	}
}

class InputWorker implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("출력 스레드 실행 " + i);
	}
}

public class TestThread4 {

	public static void main(String[] args) {
		Thread it = new Thread(new InputWorker());
		Thread ot = new Thread(new OutputWorker());
		it.start();
		ot.start();
		System.out.println("main thread 종료");
	}

}
