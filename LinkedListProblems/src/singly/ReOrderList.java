package singly;

public class ReOrderList {

	public static void main(String[] args) {

		SingleLinkedList head = new SingleLinkedList(1);
		head.next = new SingleLinkedList(2);
		head.next.next = new SingleLinkedList(3);
		head.next.next.next = new SingleLinkedList(4);
		reorderList(head);
		printList(head);
	}

	public static void reorderList(SingleLinkedList head) {
		SingleLinkedList start = head;
		SingleLinkedList end = head;
		while (end.next != null) {
			end = end.next;
		}
		while (start != end) {
			SingleLinkedList temp = start.next;
			start.next = end;
			end.next = temp;
			start = temp;

		}
	}

	static void printList(SingleLinkedList head) {
		SingleLinkedList current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
