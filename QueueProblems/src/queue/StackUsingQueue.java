package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private Queue<Integer> q1;
	private Queue<Integer> q2;

	public StackUsingQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int element) {
		q1.add(element);
	}

	public int pop() {
		if (q1.isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}

		while (q1.size() > 1) {
			q2.add(q1.remove());
		}

		int element = q1.remove();

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;

		return element;
	}

	public int peek() {
		if (q1.isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}

		while (q1.size() > 1) {
			q2.add(q1.remove());
		}

		int element = q1.peek();

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;

		return element;
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		System.out.println(stack.pop()); // 1

		System.out.println(stack.isEmpty()); // true
	}
}