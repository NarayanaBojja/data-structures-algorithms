package queue;

class QNode {
	int data;
	QNode next;

	QNode(int data) {
		this.data = data;
	}
}

public class QueueUsingLinkedListDS {
 
	QNode front;
	QNode rear;

	public void enqueue(int data) {
		QNode temp = new QNode(data);
		if (rear == null) {
			front = temp;
			rear = temp;
			return;
		}
		rear.next = temp;
		rear = temp;
	}

	public void dequeue() {
		if (front == null) {
			return;
		}
		QNode temp = front.next;
		front = front.next;
		if (front == null) {
			rear = null;
		}
	}
	public int peek() {
		return front == null ? -1 : front.data;
		
	}
	public static void main(String[] args) {
		QueueUsingLinkedListDS queue = new QueueUsingLinkedListDS();
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.dequeue();
		System.out.println("Front: " + queue.front.data);
		System.out.println("Rear: " + queue.rear.data);
		System.out.println("peek: " + queue.peek());
	}

}
