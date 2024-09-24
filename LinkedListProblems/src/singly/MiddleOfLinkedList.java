package singly;

public class MiddleOfLinkedList {
	
	public static SingleLinkedList middleofSinglyLinkedList(SingleLinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		SingleLinkedList slow = head;
		SingleLinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SingleLinkedList head = new SingleLinkedList(10);
		head.next = new SingleLinkedList(20);
		head.next.next = new SingleLinkedList(30);
		head.next.next.next = new SingleLinkedList(40);
		head.next.next.next.next = new SingleLinkedList(50);		
		SingleLinkedList middle = middleofSinglyLinkedList(head);
		System.out.println("Middle element data: " + middle.data);
	}

}
