package stack;

/**
 * ArrayStackBasicOps class implements a stack using a fixed-size array. It
 * provides basic stack operations such as push, pop, peek, and isEmpty.
 * 
 * Methods: - `push(int element)`: Pushes an element onto the stack. - `pop()`:
 * Removes and returns the top element of the stack. - `isEmpty()`: Checks if
 * the stack is empty. - `peek()`: Retrieves the top element without removing
 * it. - `print()`: Prints all elements in the stack from top to bottom.
 */
public class ArrayStackBasicOps {

	// Index of the top element in the stack (-1 indicates the stack is empty)
	private int top = -1;

	// Maximum size of the stack
	private final int size = 100;

	// Array to hold stack elements
	private int[] a = new int[size];

	/**
	 * Pushes an element onto the stack.
	 * 
	 * @param element The element to push onto the stack.
	 * @return True if the element is successfully pushed, false if the stack is
	 *         full.
	 * 
	 *         Time Complexity: O(1) - Pushing an element is a constant-time
	 *         operation. Space Complexity: O(1) - No additional space is used.
	 */
	public boolean push(int element) {
		if (top >= size - 1) { // Check for stack overflow
			System.out.println("Stack Overflow");
			return false;
		}
		a[++top] = element; // Increment top and add element
		return true;
	}

	/**
	 * Removes and returns the top element of the stack.
	 * 
	 * @return The top element, or -1 if the stack is empty.
	 * 
	 *         Time Complexity: O(1) - Removing the top element is a constant-time
	 *         operation. Space Complexity: O(1) - No additional space is used.
	 */
	public int pop() {
		if (top == -1) { // Check for stack underflow
			System.out.println("Stack Underflow");
			return -1;
		}
		return a[top--]; // Return the top element and decrement top
	}

	/**
	 * Checks if the stack is empty.
	 * 
	 * @return True if the stack is empty, false otherwise.
	 * 
	 *         Time Complexity: O(1) - Checking the stack's emptiness is constant
	 *         time. Space Complexity: O(1) - No additional space is used.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Retrieves the top element of the stack without removing it.
	 * 
	 * @return The top element, or -1 if the stack is empty.
	 * 
	 *         Time Complexity: O(1) - Accessing the top element is a constant-time
	 *         operation. Space Complexity: O(1) - No additional space is used.
	 */
	public int peek() {
		if (top == -1) { // Check for stack underflow
			System.out.println("Stack Underflow");
			return -1;
		}
		return a[top]; // Return the top element without modifying top
	}

	/**
	 * Prints all elements in the stack from top to bottom.
	 * 
	 * Time Complexity: O(N) - Printing all elements requires iterating through the
	 * stack. Space Complexity: O(1) - No additional space is used.
	 */
	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Main method to demonstrate the functionality of ArrayStackBasicOps.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		ArrayStackBasicOps arrayStackBasicOps = new ArrayStackBasicOps();
		System.out.println("Stack is Empty: " + arrayStackBasicOps.isEmpty());
		arrayStackBasicOps.push(4);
		arrayStackBasicOps.push(1);
		arrayStackBasicOps.push(7);
		arrayStackBasicOps.push(8);
		arrayStackBasicOps.push(2);
		arrayStackBasicOps.print(); // Output: 2 8 7 1 4
	}
}
