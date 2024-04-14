package queue;

import java.util.Stack;

public class QueueUsingStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	QueueUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enQueue(int data) {
		stack1.push(data);
	}

	public int deQueue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		int data = queue.deQueue();
		System.out.println("Element: " + data);
	}

}
