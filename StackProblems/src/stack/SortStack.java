package stack;

import java.util.Stack;
/**
 *
 * Time complexity: O(n^2) Space complexity:  O(n)
 */
public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(2);
		stack.push(1);
		stack.push(7);
		stack.push(5);
		sortStack(stack);
		System.out.println("After sorting");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

	private static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int top = stack.pop();
		sortStack(stack);
		insertAtCorrectPosition(stack, top);
	}

	private static void insertAtCorrectPosition(Stack<Integer> stack, int top) {
		if (stack.isEmpty() || top > stack.peek()) {
			stack.push(top);
			return;
		}
		int temp = stack.pop();
		insertAtCorrectPosition(stack, top);
		stack.push(temp);
	}

}
