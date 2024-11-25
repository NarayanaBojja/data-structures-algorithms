package stack;

/**
 * Class representing a node in a linked list stack.
 */
class StackNode {
	// Data stored in the node
	int data;

	// Pointer to the next node in the stack
	StackNode next;

	/**
	 * Constructor to initialize a StackNode.
	 * 
	 * @param data The data to store in the node.
	 */
	StackNode(int data) {
		this.data = data;
	}
}

/**
 * LinkedListStackBasicOps class implements a stack using a linked list.
 * Provides standard stack operations: push, pop, peek, isEmpty, and display.
 * 
 * Methods: - `push(int data)`: Adds an element to the top of the stack. -
 * `pop()`: Removes and returns the top element of the stack. - `isEmpty()`:
 * Checks if the stack is empty. - `peek()`: Retrieves the top element without
 * removing it. - `display()`: Prints all elements in the stack from top to
 * bottom.
 */
public class LinkedListStackBasicOps {

	// Top of the stack
	StackNode top;

	/**
	 * Pushes an element onto the stack.
	 * 
	 * @param data The data to push onto the stack.
	 * @return True if the element is successfully pushed.
	 * 
	 *         Time Complexity: O(1) - Adding a new node is a constant-time
	 *         operation. Space Complexity: O(1) - No additional space is used apart
	 *         from the new node.
	 */
	public boolean push(int data) {
		StackNode temp = new StackNode(data);
		temp.next = top; // Link the new node to the current top
		top = temp; // Update the top pointer
		return true;
	}

	/**
	 * Removes and returns the top element of the stack.
	 * 
	 * @return The data of the top element, or -1 if the stack is empty.
	 * 
	 *         Time Complexity: O(1) - Removing the top node is a constant-time
	 *         operation. Space Complexity: O(1) - No additional space is used.
	 */
	public int pop() {
		if (top == null) { // Check for underflow
			System.out.println("Stack Underflow");
			return -1;
		}
		int data = top.data; // Retrieve the top data
		top = top.next; // Update the top pointer to the next node
		return data;
	}

	/**
	 * Checks if the stack is empty.
	 * 
	 * @return True if the stack is empty, false otherwise.
	 * 
	 *         Time Complexity: O(1) - Checking the top pointer is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Retrieves the top element of the stack without removing it.
	 * 
	 * @return The data of the top element, or -1 if the stack is empty.
	 * 
	 *         Time Complexity: O(1) - Accessing the top node is constant time.
	 *         Space Complexity: O(1) - No additional space is used.
	 */
	public int peek() {
		if (top == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return top.data;
	}

	/**
	 * Displays all elements in the stack from top to bottom.
	 * 
	 * Time Complexity: O(N) - Printing all elements requires traversing the stack.
	 * Space Complexity: O(1) - No additional space is used.
	 */
	public void display() {
		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}
		StackNode temp = top;
		while (temp != null) { // Traverse from top to bottom
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * Main method to demonstrate the functionality of LinkedListStackBasicOps.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		LinkedListStackBasicOps linkedListStackBasicOps = new LinkedListStackBasicOps();

		linkedListStackBasicOps.push(8);
		linkedListStackBasicOps.push(1);
		linkedListStackBasicOps.push(4);
		linkedListStackBasicOps.push(2);
		linkedListStackBasicOps.push(6);

		System.out.println("Stack elements:");
		linkedListStackBasicOps.display(); // Output: 6 2 4 1 8

		linkedListStackBasicOps.pop();
		System.out.println("After popping one element:");
		linkedListStackBasicOps.display(); // Output: 2 4 1 8
	}
}
