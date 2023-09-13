import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(100); // enqueue
		queue.offer(200); // enqueue
		queue.offer(300); // enqueue
		System.out.println(queue.poll()); // dequeue삭제하고 가져오지 않음.
		System.out.println(queue.poll()); // 삭제하고 가져오지 않음.
		System.out.println(queue.poll()); // 삭제하고 가져오지 않음.
		
		queue.clear(); // 초기화
	}

}
