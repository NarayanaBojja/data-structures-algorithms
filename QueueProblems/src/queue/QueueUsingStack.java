package queue;

import java.util.Stack;

/**
 * QueueUsingStack class implements a queue using two stacks (LIFO data
 * structures). This implementation supports standard queue operations: enQueue,
 * deQueue, peek, and size.
 * 
 * Methods: - `enQueue(int data)`: Adds an element to the end of the queue. -
 * `deQueue()`: Removes and returns the front element of the queue. - `peek()`:
 * Retrieves the front element without removing it. - `size()`: Returns the
 * number of elements in the queue.
 */
public class QueueUsingStack {

	// Stack to hold elements being enqueued
	private Stack<Integer> stack1;

	// Stack to hold elements for dequeuing
	private Stack<Integer> stack2;

	/**
	 * Constructor to initialize the QueueUsingStack object.
	 */
	public QueueUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param data The element to add to the queue.
	 * 
	 *             Time Complexity: O(1) - Pushing to a stack is constant time.
	 *             Space Complexity: O(1) - No additional space is used beyond
	 *             storing the element.
	 */
	public void enQueue(int data) {
		stack1.push(data);
	}

	/**
	 * Removes and returns the front element of the queue. If `stack2` is empty,
	 * elements from `stack1` are transferred to `stack2` to maintain queue order.
	 * 
	 * @return The front element of the queue.
	 * @throws IllegalStateException If the queue is empty.
	 * 
	 *                               Time Complexity: Amortized O(1) - On average,
	 *                               each element is moved between stacks once. In
	 *                               the worst case, transferring elements from
	 *                               `stack1` to `stack2` takes O(N), where N is the
	 *                               number of elements in the queue. Space
	 *                               Complexity: O(1) - No additional space is used
	 *                               during the transfer.
	 */
	public int deQueue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return stack2.pop();
	}

	/**
	 * Retrieves the front element of the queue without removing it. If `stack2` is
	 * empty, elements from `stack1` are transferred to `stack2`.
	 * 
	 * @return The front element of the queue.
	 * @throws IllegalStateException If the queue is empty.
	 * 
	 *                               Time Complexity: Amortized O(1) - Similar to
	 *                               deQueue, on average, each element is moved
	 *                               between stacks once. In the worst case,
	 *                               transferring elements from `stack1` to `stack2`
	 *                               takes O(N), where N is the number of elements
	 *                               in the queue. Space Complexity: O(1) - No
	 *                               additional space is used during the transfer.
	 */
	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return stack2.peek();
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return The number of elements in the queue.
	 * 
	 *         Time Complexity: O(1) - Calculating the size is constant time. Space
	 *         Complexity: O(1) - No additional space is used.
	 */
	public int size() {
		return stack1.size() + stack2.size();
	}

	/**
	 * Main method to demonstrate the functionality of QueueUsingStack.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);

		int data = queue.deQueue();
		System.out.println("Element: " + data); // Output: 10
		System.out.println("Peek: " + queue.peek()); // Output: 30
		System.out.println("Size: " + queue.size()); // Output: 3
	}
}
