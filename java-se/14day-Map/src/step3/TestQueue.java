package step3;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("안녕 나 인성이야");
		queue.add("자니?");
		queue.add("자는구나..");
		queue.add("안녕...");
		while(queue.isEmpty()==false){
			System.out.println(queue.poll());
		}
		// Queue 선입선출 FIFO
	}

}
