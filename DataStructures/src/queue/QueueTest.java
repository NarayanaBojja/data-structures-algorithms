package queue;

public class QueueTest {

	public static void main(String[] args) {
		QueueDS queue = new QueueDS(5);
		System.out.println("Is empty: " + queue.isEmpty());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println("Is empty: " + queue.isEmpty());
		System.out.println("Is Full: " + queue.isFull());
		System.out.println(queue.dequeue() + " dequeued item");
		System.out.println("Front: " + queue.front());
		System.out.println("Rear: " + queue.rear());
	}

}
