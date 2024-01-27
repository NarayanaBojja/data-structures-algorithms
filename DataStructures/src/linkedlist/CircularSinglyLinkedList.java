package linkedlist;

class CircularSinglyLinkedListNode {

	int data;
	CircularSinglyLinkedListNode next;

	public CircularSinglyLinkedListNode(int data) {
		super();
		this.data = data;
	}

}

public class CircularSinglyLinkedList {

	CircularSinglyLinkedListNode head;

	public CircularSinglyLinkedListNode addFirst(int data) {
		CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(data);
		if (head == null) {
			head = newNode;
			head.next = head;
			return head;
		}
		newNode.next = head;
		head = newNode;
		return head;
	}

	public void addEnd(int data) {
		CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(data);
		if (head == null) {
			head = newNode;
			head.next = head;
			return;
		}
		newNode.next = head.next;
		head.next = newNode;
		int headData = head.data;
		head.data = newNode.data;
		newNode.data = headData;
		head = newNode;
	}

	public void deleteHead() {
		if (head == null || head.next == null) {
			head = null;
			return;
		}
		head.data = head.next.data;
		head.next = head.next.next;
	}

	public void print() {
		if (head == null) {
			return;
		}
		CircularSinglyLinkedListNode current = head;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		} while (current != null && current != head);
		System.out.println();
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList csl = new CircularSinglyLinkedList();
		CircularSinglyLinkedListNode newNodeOne = csl.addFirst(2);
		CircularSinglyLinkedListNode newNodeTwo = csl.addFirst(1);
		CircularSinglyLinkedListNode newNodeThree = csl.addFirst(6);
		CircularSinglyLinkedListNode newNodeFour = csl.addFirst(3);
		newNodeOne.next = newNodeFour;
		csl.addEnd(9);
		csl.print();
		csl.deleteHead();
		csl.print();
	}

}
