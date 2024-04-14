package singly;

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/description/ time
 * complexity: O(n) Space complexity : O(1)
 */
public class ReverseSinglyLinkedList {
	public SingleLinkedList reverseSinglyLinkedList(SingleLinkedList head) {
		if(head == null || head.next == null) {
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

	public static void main(String[] args) {
		SingleLinkedList head = new SingleLinkedList(10);
		head.next = new SingleLinkedList(20);
		head.next.next = new SingleLinkedList(30);
		head.next.next.next = new SingleLinkedList(40);
		var reverseSinglyLinkedList = new ReverseSinglyLinkedList();
		head = reverseSinglyLinkedList.reverseSinglyLinkedList(head);
		SinglyLinkedListOps.printlist(head);
	}

}
