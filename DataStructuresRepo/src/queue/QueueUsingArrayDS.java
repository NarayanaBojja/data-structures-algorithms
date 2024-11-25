package queue;

/**
 * QueueUsingArrayDS implements a circular queue using a fixed-size array. It
 * provides basic queue operations: enqueue, dequeue, check if the queue is
 * empty or full, and access the front or rear element.
 * 
 * Methods: - `isFull()`: Checks if the queue is full. - `isEmpty()`: Checks if
 * the queue is empty. - `enqueue(int item)`: Adds an element to the rear of the
 * queue. - `dequeue()`: Removes and returns the front element of the queue. -
 * `front()`: Retrieves the front element without removing it. - `rear()`:
 * Retrieves the rear element without removing it.
 */
public class QueueUsingArrayDS {

	// Index of the front element in the queue
	private int front;

	// Index of the rear element in the queue
	private int rear;

	// Current size of the queue
	private int size;

	// Maximum capacity of the queue
	private final int capacity;

	// Array to hold the queue elements
	private final int[] array;

	/**
	 * Constructor to initialize a queue with a given capacity.
	 * 
	 * @param capacity The maximum number of elements the queue can hold.
	 */
	QueueUsingArrayDS(int capacity) {
		this.capacity = capacity;
		front = 0;
		size = 0;
		rear = capacity - 1; // Rear starts at the last index for circular operation
		array = new int[capacity];
	}

	/**
	 * Checks if the queue is full.
	 * 
	 * @return True if the queue is full, false otherwise.
	 * 
	 *         Time Complexity: O(1) - Checking the size is constant time. Space
	 *         Complexity: O(1) - No additional space is used.
	 */
	public boolean isFull() {
		return this.size == this.capacity;
	}

	/**
	 * Checks if the queue is empty.
	 * 
	 * @return True if the queue is empty, false otherwise.
	 * 
	 *         Time Complexity: O(1) - Checking the size is constant time. Space
	 *         Complexity: O(1) - No additional space is used.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Adds an element to the rear of the queue.
	 * 
	 * @param item The element to add to the queue.
	 * 
	 *             Time Complexity: O(1) - Adding an element is constant time. Space
	 *             Complexity: O(1) - No additional space is used.
	 */
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}
		rear = (rear + 1) % capacity; // Circular increment of rear
		array[rear] = item; // Add the element
		size = size + 1; // Increment size
	}

	/**
	 * Removes and returns the front element of the queue.
	 * 
	 * @return The front element, or Integer.MIN_VALUE if the queue is empty.
	 * 
	 *         Time Complexity: O(1) - Removing an element is constant time. Space
	 *         Complexity: O(1) - No additional space is used.
	 */
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return Integer.MIN_VALUE;
		}
		int item = array[front]; // Get the front element
		front = (front + 1) % capacity; // Circular increment of front
		size = size - 1; // Decrement size
		return item;
	}

	/**
	 * Retrieves the front element without removing it.
	 * 
	 * @return The front element, or Integer.MIN_VALUE if the queue is empty.
	 * 
	 *         Time Complexity: O(1) - Accessing the front element is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public int front() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		return array[front];
	}

	/**
	 * Retrieves the rear element without removing it.
	 * 
	 * @return The rear element, or Integer.MIN_VALUE if the queue is empty.
	 * 
	 *         Time Complexity: O(1) - Accessing the rear element is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public int rear() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		return array[rear];
	}
}
