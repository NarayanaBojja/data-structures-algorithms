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

	public void addFirst(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
	}

	public void printDoublyLinkedList() {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(4);
		dll.addFirst(5);
		dll.addFirst(1);
		dll.addFirst(7);
		dll.printDoublyLinkedList();
	}

}
