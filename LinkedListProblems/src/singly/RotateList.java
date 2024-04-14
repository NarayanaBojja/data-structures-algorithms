package singly;

public class RotateList {
	public static SingleLinkedList rotateRight(SingleLinkedList head, int k) {
		if (k == 0 || head == null || head.next == null) {
			return head;
		}
		int size = 1;
		SingleLinkedList current = head;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		k = k % size;

		int start = size - k;
		current.next = head;
		while (start > 0) {
			current = current.next;
			start--;
		}
		head = current.next;
		current.next = null;
		return head;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList(1);
		list.next = new SingleLinkedList(2);
		list.next.next = new SingleLinkedList(3);
		list.next.next.next = new SingleLinkedList(4);
		list.next.next.next.next = new SingleLinkedList(5);
		SingleLinkedList newHead = rotateRight(list, 2);
		SinglyLinkedListOps.printlist(newHead);
	}

}
