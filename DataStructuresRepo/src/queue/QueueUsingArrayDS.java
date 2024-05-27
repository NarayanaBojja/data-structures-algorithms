package queue;

public class QueueUsingArrayDS {
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private int[] array;

	QueueUsingArrayDS(int capacity) {
		this.capacity = capacity;
		front = 0;
		size = 0;
		rear = capacity - 1;
		array = new int[capacity];
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enqueue(int item) {
		if (isFull()) {
			return;
		}
		rear = (rear + 1) % capacity;
		array[rear] = item;
		this.size = size + 1;
	}

	public int dequeue() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int item = array[front];
		size = size - 1;
		front = (front + 1) % capacity;
		return item;
	}

	public int front() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}

		return array[front];
	}

	public int rear() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}

		return array[rear];
	}
}
