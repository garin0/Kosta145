package step3;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("�ȳ� �� �μ��̾�");
		queue.add("�ڴ�?");
		queue.add("�ڴ±���..");
		queue.add("�ȳ�...");
		while(queue.isEmpty()==false){
			System.out.println(queue.poll());
		}
		// Queue ���Լ��� FIFO
	}

}
