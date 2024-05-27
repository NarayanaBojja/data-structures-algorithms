package stack;

class StackNode {
	int data;
	StackNode next;

	StackNode(int data) {
		this.data = data;
	}
}

public class LinkedListStackBasicOps {
	StackNode top;

	public boolean push(int data) {
		StackNode temp = new StackNode(data);
		temp.data = data;
		temp.next = top;
		top = temp;
		return true;
	}

	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		if (top == null) {
			return -1;
		}
		return top.data;
	}

	public void display() {
		if (top != null) {
			StackNode temp = top;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		LinkedListStackBasicOps linkedListStackBasicOps = new LinkedListStackBasicOps();
		linkedListStackBasicOps.push(8);
		linkedListStackBasicOps.push(1);
		linkedListStackBasicOps.push(4);
		linkedListStackBasicOps.push(2);
		linkedListStackBasicOps.push(6);
		linkedListStackBasicOps.display();
		linkedListStackBasicOps.pop();
		System.out.println();
		System.out.println("After popping one element");
		linkedListStackBasicOps.display();
	}
}
