package step3;

// implements Runnable
class Worker implements Runnable {
	@Override
	// Worker thread ���� ����
	// jvm�� ���� ����
	public void run() {
		for (int i = 0; i < 100; i++)
			System.out.println("worker thread ���� " + i);
	}

}

public class TestThread3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Worker());
		t.start();
		Thread.sleep(1); // 0.001�ʰ� �ߴ� �� �簳
		System.out.println("main thread ����");
	}

}
