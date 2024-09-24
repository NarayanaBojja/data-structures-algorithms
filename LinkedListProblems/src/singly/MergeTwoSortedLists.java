package singly;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Time complexity : O(n + m) Space complexity is O(1)
 */
public class MergeTwoSortedLists {

	public static SingleLinkedList mergeTwoSortedLists(SingleLinkedList list1, SingleLinkedList list2) {
		SingleLinkedList p1 = list1;
		SingleLinkedList p2 = list2;
		SingleLinkedList head = new SingleLinkedList(0);
		SingleLinkedList p = head;
		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null) {
			p.next = p1;
		}
		if (p2 != null) {
			p.next = p2;
		}
		return head.next;

	}

	public static void main(String[] args) {
		SingleLinkedList head1 = new SingleLinkedList(1);
		head1.next = new SingleLinkedList(2);
		head1.next.next = new SingleLinkedList(4);
		head1.next.next.next = new SingleLinkedList(5);
		head1.next.next.next.next = new SingleLinkedList(6);
		SingleLinkedList head2 = new SingleLinkedList(1);
		head2.next = new SingleLinkedList(3);
		head2.next.next = new SingleLinkedList(4);
		head2.next.next.next = new SingleLinkedList(7);
		head2.next.next.next.next = new SingleLinkedList(8);
		SingleLinkedList mergedList = mergeTwoSortedLists(head1, head2);
		SinglyLinkedListOps.printlist(mergedList);
	}

}
