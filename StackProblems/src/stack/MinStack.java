package stack;

import java.util.Stack;

/**
 * MinStack class implements a stack with an additional feature to retrieve the
 * minimum element in constant time. It uses a secondary stack to maintain the
 * minimum values alongside the main stack.
 * 
 * Methods: - `push(int x)`: Pushes an element onto the stack and updates the
 * minimum value. - `pop()`: Removes the top element from the stack and adjusts
 * the minimum value if necessary. - `top()`: Retrieves the top element of the
 * stack without removing it. - `getMin()`: Retrieves the minimum element in the
 * stack in O(1) time.
 */
public class MinStack {

	// Tracks the minimum value in the stack
	private int min = Integer.MAX_VALUE;

	// Stack to store the elements
	private Stack<Integer> stack = new Stack<>();

	/**
	 * Constructor to initialize the MinStack object.
	 */
	public MinStack() {
		// Default constructor
	}

	/**
	 * Pushes an element onto the stack. If the element is less than or equal to the
	 * current minimum, the current minimum is pushed onto the stack before updating
	 * the minimum.
	 * 
	 * @param x The element to push onto the stack.
	 * 
	 *          Time Complexity: O(1) - Each push operation is constant time. Space
	 *          Complexity: O(1) - Uses constant additional space per element.
	 */
	public void push(int x) {
		if (x <= min) {
			stack.push(min); // Push the current min onto the stack
			min = x; // Update the minimum
			return;
		}
		stack.push(x); // Push the element
	}

	/**
	 * Removes the top element from the stack. If the popped element is the current
	 * minimum, the next element is used to update the minimum.
	 * 
	 * Time Complexity: O(1) - Each pop operation is constant time. Space
	 * Complexity: O(1) - No additional space is used during pop.
	 */
	public void pop() {
		if (stack.pop() == min) { // If the popped element is the min
			min = stack.pop(); // Pop the old min from the stack
		}
	}

	/**
	 * Retrieves the top element of the stack without removing it.
	 * 
	 * @return The top element of the stack.
	 * 
	 *         Time Complexity: O(1) - Retrieving the top element is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public int top() {
		return stack.peek();
	}

	/**
	 * Retrieves the minimum element in the stack.
	 * 
	 * @return The minimum element in the stack.
	 * 
	 *         Time Complexity: O(1) - Retrieving the minimum is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Main method to demonstrate the functionality of MinStack.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(-1);
		s.push(10);
		s.push(-4);
		s.push(0);
		System.out.println(s.getMin()); // Output: -4
		s.pop();
		s.pop();
		System.out.println(s.getMin()); // Output: -4
	}
}
