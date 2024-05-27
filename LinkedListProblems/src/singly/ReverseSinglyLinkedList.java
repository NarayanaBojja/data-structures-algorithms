package singly;

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseSinglyLinkedList {
	/**
	 * time complexity: O(n) Space complexity : O(1)
	 * 
	 */
	public SingleLinkedList reverseSinglyLinkedList(SingleLinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		SingleLinkedList current = head;
		SingleLinkedList previous = null;
		while (current != null) {
			SingleLinkedList temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head = previous;
		return head;
	}

	/**
	 * time complexity: O(n) Space complexity : O(n)
	 * 
	 */
	public SingleLinkedList reverseListRecursively(SingleLinkedList head) {
		// Base case: if the list is empty or has only one node, return it
		if (head == null || head.next == null) {
			return head;
		}
		// Reverse the sublist starting from the second node recursively
		SingleLinkedList reversedList = reverseListRecursively(head.next);
		// Reverse the pointers: make the next node point to the current node
		head.next.next = head;
		head.next = null;
		// Return the new head of the reversed list
		return reversedList;
	}

	public static void main(String[] args) {
		SingleLinkedList head = new SingleLinkedList(10);
		head.next = new SingleLinkedList(20);
		head.next.next = new SingleLinkedList(30);
		head.next.next.next = new SingleLinkedList(40);
		var reverseSinglyLinkedList = new ReverseSinglyLinkedList();
//		head = reverseSinglyLinkedList.reverseSinglyLinkedList(head);
//		SinglyLinkedListOps.printlist(head);
		head = reverseSinglyLinkedList.reverseListRecursively(head);
		SinglyLinkedListOps.printlist(head);
	}

}
