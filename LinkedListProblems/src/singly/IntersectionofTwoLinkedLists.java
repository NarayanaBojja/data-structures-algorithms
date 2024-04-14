package singly;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Time complexity : O(m + n) Space complexity is O(1)
 */
public class IntersectionofTwoLinkedLists {

	public static SingleLinkedList getIntersectionNode(SingleLinkedList headA, SingleLinkedList headB) {
		SingleLinkedList ptrA = headA;
		SingleLinkedList ptrB = headB;
		while (ptrA != ptrB) {
			ptrA = ptrA == null ? headB : ptrA.next;
			ptrB = ptrB == null ? headA : ptrB.next;
		}
		return ptrA;
	}

	public static void main(String[] args) {
		SingleLinkedList node = new SingleLinkedList(7);
		SingleLinkedList list1 = new SingleLinkedList(2);
		list1.next = new SingleLinkedList(4);
		list1.next.next = node;
		SingleLinkedList list2 = new SingleLinkedList(5);
		list2.next = new SingleLinkedList(6);
		list2.next.next = new SingleLinkedList(4);
		list2.next.next.next = node;
		SingleLinkedList newNode = getIntersectionNode(list1, list2);
		System.out.println(newNode);
	}

}
