package step2;

/* ��Ƽ �����带 �����ؼ� �����غ���.
 * Main Thread + Worker Thread ���ÿ� �ΰ��� �����带 ������� �� ����� Ȯ���Ѵ�.
 * (step1 ������ � �������� �ִ��� �м�)
 */
class Worker extends Thread {
	// run()�� �������̵� �Ͽ� Worker �������� �۾� ������ �����Ѵ�.
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("����(thread) ���� �ϴ� " + i);
	}

}

public class TestThread2 {

	public static void main(String[] args) {
		Worker wt = new Worker(); // ������ ����
		wt.start(); // �����带 ���� ���� ���·� ������. jvm�� �����ٸ��� �ϸ� ����ȴ�.
		// jvm�� ���� run() �޼��尡 ȣ��ȴٴ� ���� �ǹ�.
		System.out.println("main thread ����");
	}

}
