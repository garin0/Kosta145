package step4;

/* ä�� Ŭ���̾�Ʈ
 * ���� �޼����� ������ ��� (��� ������)
 * ģ������ �޼����� �Է� (�Է� ������)
 */
class OutputWorker implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("�Է� ������ ���� " + i);
	}
}

class InputWorker implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("��� ������ ���� " + i);
	}
}

public class TestThread4 {

	public static void main(String[] args) {
		Thread it = new Thread(new InputWorker());
		Thread ot = new Thread(new OutputWorker());
		it.start();
		ot.start();
		System.out.println("main thread ����");
	}

}
