package singly;

public class RemoveNthFromEnd {

	public static SingleLinkedList removeNthFromEnd(SingleLinkedList head, int n) {
		int size = 0;
		SingleLinkedList temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		if (size == n) {
			head = head.next;
			return head;
		}

		int positionToRemove = size - n + 1;
		SingleLinkedList prev = null;
		SingleLinkedList next = head;
		for (int i = 1; i < positionToRemove; i++) {
			prev = next;
			next = next.next;
		}
		prev.next = next.next;
		return head;
	}

	public static void main(String[] args) {
		SingleLinkedList head = new SingleLinkedList(10);
		head.next = new SingleLinkedList(20);
		head.next.next = new SingleLinkedList(30);
		head.next.next.next = new SingleLinkedList(40);
		head.next.next.next.next = new SingleLinkedList(50);
		head = removeNthFromEnd(head, 2);
		SinglyLinkedListOps.printlist(head);
	}

}
