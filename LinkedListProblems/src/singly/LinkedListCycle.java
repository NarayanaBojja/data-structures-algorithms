package singly;
/**
 * Time Complexity : O(n) Space Complexity: O(1)
 */
public class LinkedListCycle {

	public static boolean hasCycle(SingleLinkedList head) {
		if (head == null) {
			return false;
		}
		SingleLinkedList slow = head;
		SingleLinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList(2);
		SingleLinkedList second = new SingleLinkedList(4);
		list1.next = second;
		list1.next.next = new SingleLinkedList(3);
		SingleLinkedList five = new SingleLinkedList(4);
		list1.next.next.next = five;
		five.next = second;
		System.out.println(hasCycle(list1));
	}

}
