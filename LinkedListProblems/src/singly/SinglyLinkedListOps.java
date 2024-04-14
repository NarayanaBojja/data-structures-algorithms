package singly;

public class SinglyLinkedListOps {

	static SingleLinkedList push(SingleLinkedList head_ref, int new_data) {
		SingleLinkedList new_SingleLinkedList = new SingleLinkedList(new_data);
		new_SingleLinkedList.next = head_ref;
		(head_ref) = new_SingleLinkedList;
		return head_ref;
	}

	// Function to remove the first SingleLinkedList
	// of the linked list /
	static SingleLinkedList removeFirstSingleLinkedList(SingleLinkedList head) {
		if (head == null)
			return null;

		// Move the head pointer to the next SingleLinkedList
		SingleLinkedList temp = head;
		head = head.next;

		return head;
	}

	static SingleLinkedList removeLastSingleLinkedList(SingleLinkedList head) {
		if (head == null)
			return null;

		if (head.next == null) {
			return null;
		}

		// Find the second last SingleLinkedList
		SingleLinkedList second_last = head;
		while (second_last.next.next != null)
			second_last = second_last.next;

		// Change next of second last
		second_last.next = null;

		return head;
	}

	static int search(SingleLinkedList head, int data) {
		int pos = 1;
		while (head != null) {
			if (head.data == data) {
				return pos;
			} else {
				pos++;
				head = head.next;
			}
		}
		return -1;
	}

	static int searchRecursive(SingleLinkedList head, int x) {
		if (head == null)
			return -1;
		if (head.data == x)
			return 1;
		else {
			int res = searchRecursive(head.next, x);
			if (res == -1)
				return -1;
			else
				return res + 1;
		}
	}

	static void printlist(SingleLinkedList head) {
		if (head == null) {
			return;
		}
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		SingleLinkedList head = new SingleLinkedList(10);
		head.next = new SingleLinkedList(20);
		head.next.next = new SingleLinkedList(30);
		printlist(head);
		System.out.println("Position of element in Linked List: " + search(head, 20));
		System.out.println("Position of element in Linked List: " + searchRecursive(head, 30));
	}

}
