package stack;

import java.util.Stack;

public class MinStack {

	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<>();

	public MinStack() {

	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min) {
			min = stack.pop();
		}

	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {

	}

}
