package singly;

public class SingleLinkedList {
	int data;
	SingleLinkedList next;
	public SingleLinkedList random;

	SingleLinkedList(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SingleLinkedList [data=" + data + ", next=" + next + "]";
	}
	
}
