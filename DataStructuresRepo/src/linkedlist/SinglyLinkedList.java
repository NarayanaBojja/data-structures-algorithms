package linkedlist;

class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode(int data) {
		super();
		this.data = data;
	}

}

public class SinglyLinkedList {

	SinglyLinkedListNode root;

	public void addFirst(int data) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		if (root == null) {
			root = node;
			return;
		}
		node.next = root;
		root = node;
	}

	public void addAfter(SinglyLinkedListNode previous, int data) {
		if (previous == null) {
			return;
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}

	public void addEnd(int data) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		if (root == null) {
			root = newNode;
			return;
		}
		SinglyLinkedListNode lastNode = root;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
	}

	public void deleteFirst() {
		if (root == null) {
			return;
		}
		root = root.next;
	}

	public void deleteLast() {
		if (root == null || root.next == null) {
			root = null;
		}
		SinglyLinkedListNode secondLast = root;
		while (secondLast.next.next != null) {
			secondLast = secondLast.next;
		}
		secondLast.next = null;
	}

	public int searchDataIterative(SinglyLinkedListNode current, int data) {
		int pos = 1;
		while (current != null) {
			if (current.data == data) {
				return pos;
			} else {
				pos++;
				current = current.next;
			}
		}
		return -1;

	}

	public int searchDataRecursive(SinglyLinkedListNode current, int data) {
		if (current == null) {
			return -1;
		}
		if (current.data == data) {
			return 1;
		} else {
			int res = searchDataRecursive(current.next, data);
			if (res == -1) {
				return -1;
			} else {
				return 1 + res;
			}
		}

	}

	public void reverseSinglyLinkedList() {
		SinglyLinkedListNode current = root;
		SinglyLinkedListNode previous = null;
		while (current != null) {
			SinglyLinkedListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		root = previous;
	}

	public SinglyLinkedListNode reverseSinglyLinkedListRecursively(SinglyLinkedListNode current,
			SinglyLinkedListNode previous) {

		if (current != null) {
			SinglyLinkedListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
			return reverseSinglyLinkedListRecursively(current, previous);
		} else {
			root = previous;
		}
		return previous;
	}

	public void printSinglyLinkedList() {
		SinglyLinkedListNode temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void printSinglyLinkedListRecursive(SinglyLinkedListNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printSinglyLinkedListRecursive(root.next);

	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.addFirst(1);
		sll.addFirst(2);
		sll.addFirst(3);
		sll.addFirst(4);
		sll.addFirst(5);
		sll.printSinglyLinkedList();
		// sll.reverseSinglyLinkedList();
		System.out.println();
		// sll.deleteLast();

		// sll.reverseSinglyLinkedListRecursively(sll.root, null);
		//sll.printSinglyLinkedListRecursive(sll.root);
		int posIterative = sll.searchDataRecursive(sll.root, 2);
		System.out.println("\n2 pos: " + posIterative);
	}
}
