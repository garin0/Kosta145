package step6;

/*
 * ������ �켱���� �����ٸ��� ���� �׽�Ʈ
 */
class Worker extends Thread {

	@Override
	public void run() {
		for(int i = 0 ; i <900000000 ; i++){}
		System.out.println(getName() + " ������ ����..�켱����:"+ getPriority());
	}

}

public class TestThread6 {

	public static void main(String[] args) {
/*		Worker t1 = new Worker();
		t1.setName("ù��° �ϲ�");
		Worker t2 = new Worker();
		t2.setName("�ι�° �ϲ�");
		t1.start(); t2.start();
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);*/
		/*
		 * ������ �켱���� �׽�Ʈ�� ���� worker ������ 20�� �����ϰ�
		 * ������ �����忡 �̸��� ����(0��° ������)�ϰ� 
		 * 10�� �ε����� �ش��ϴ� ������ �ϳ��� setPriority(10)
		 * ������ 19���� setPriority(1);
		 * ���� start()
		 */
		for (int i = 0; i < 20; i++) {
			Worker t = new Worker();
			t.setName(i+"��°");
			if(i==10){
				t.setPriority(Thread.MAX_PRIORITY);
			}else{
				t.setPriority(Thread.MIN_PRIORITY);
			}
			t.start();
		}

	}

}
