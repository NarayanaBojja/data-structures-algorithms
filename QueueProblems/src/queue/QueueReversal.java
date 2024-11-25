package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * QueueReversal class provides a method to reverse the elements of a queue using a stack.
 * 
 * The main method demonstrates the reversal of a queue and prints the reversed elements.
 * 
 * Methods:
 * - `reverseQueue(Queue<Integer> queue)`: Reverses the order of elements in a given queue.
 */
public class QueueReversal {

    /**
     * Main method to demonstrate the functionality of reversing a queue.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        // Reverse the queue
        Queue<Integer> reversedQueue = reverseQueue(queue);
        
        // Print the reversed queue
        while (!reversedQueue.isEmpty()) {
            System.out.print(reversedQueue.poll() + " "); // Output: 5 4 3 2 1
        }
    }

    /**
     * Reverses the order of elements in the given queue using a stack.
     * 
     * @param queue The input queue to be reversed.
     * @return The reversed queue.
     * 
     * Time Complexity: O(N)
     * - The first loop transfers all elements from the queue to the stack, taking O(N) time.
     * - The second loop transfers all elements from the stack back to the queue, taking O(N) time.
     * - Total time complexity: O(N).
     * 
     * Space Complexity: O(N)
     * - The stack requires additional space to store the elements of the queue.
     */
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Transfer elements from the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        // Transfer elements from the stack back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        return queue;
    }
}

