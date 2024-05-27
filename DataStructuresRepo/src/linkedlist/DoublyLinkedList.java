package linkedlist;

class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode next;
	DoublyLinkedListNode prev;

	public DoublyLinkedListNode(int data) {
		super();
		this.data = data;
	}

}

public class DoublyLinkedList {
	DoublyLinkedListNode head;

	public DoublyLinkedListNode addFirst(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		return head;
	}

	public void addAfter(DoublyLinkedListNode prev, int data) {
		if (prev == null) {
			return;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = prev.next;
		newNode.prev = prev;
		prev.next = newNode;
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}

	public void addBefore(DoublyLinkedListNode next, int data) {
		if (next == null) {
			return;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = next;
		newNode.prev = next.prev;
		next.prev = newNode;
		if (newNode.prev != null) {
			newNode.prev.next = newNode;
		}
	}

	public void addEnd(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		if (head == null) {
			head = newNode;
		}
		DoublyLinkedListNode lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
		newNode.prev = lastNode;
	}

	public void printDoublyLinkedList() {
		DoublyLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void reverse() {
		DoublyLinkedListNode temp = null;
		DoublyLinkedListNode current = head;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
	}

	public void deleteHead() {
		if (head == null) {
			return;
		}
		head = head.next;
	}

	public void deleteEnd() {
		if (head == null) {
			return;
		}
		DoublyLinkedListNode last = head;
		while (last.next != null) {
			last = last.next;
		}
		DoublyLinkedListNode prev = last.prev;
		last.prev = null;
		prev.next = null;
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(4);
		DoublyLinkedListNode node5 = dll.addFirst(5);
		dll.addFirst(1);
		dll.addFirst(7);
		dll.addAfter(node5, 10);
		dll.addBefore(node5, 6);
		dll.addEnd(9);
		dll.printDoublyLinkedList();
		//dll.reverse();
		dll.deleteEnd();
		dll.printDoublyLinkedList();
	}

}
