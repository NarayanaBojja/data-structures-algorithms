package queue;

class DequeNode {
	int data;
	DequeNode prev;
	DequeNode next;

	DequeNode(int data) {
		this.data = data;
	}
}

public class DequeType {
	DequeNode front;
	DequeNode rear;

	public boolean isEmpty() {
		return front == null;
	}

	public void addFirst(int data) {
		DequeNode newNode = new DequeNode(data);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
	}

	public void addLast(int data) {
		DequeNode newNode = new DequeNode(data);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			newNode.prev = rear;
			rear = newNode;
		}
	}

	public int deleteFirst() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Dequeue is empty");
		}
		int data = front.data;
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			front = front.next;
			front.prev = null;
		}
		return data;
	}

	public int deleteLast() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Dequeue is empty");
		}
		int data = front.data;
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			rear = rear.prev;
			rear.next = null;
		}
		return data;
	}

	public void display() {
		DequeNode current = front;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DequeType deque = new DequeType();

		deque.addFirst(1);
		deque.addLast(2);
		deque.addFirst(3);
		deque.addLast(4);

		deque.display();

		deque.deleteFirst();
		deque.deleteLast();

		deque.display();
	}

}
