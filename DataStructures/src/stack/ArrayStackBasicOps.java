package stack;

public class ArrayStackBasicOps {
	int top = -1;
	int size = 100;
	int a[] = new int[size];

	public boolean push(int element) {
		if (top >= size) {
			System.out.println("Stack Overflow");
			return false;
		}
		a[++top] = element;
		return true;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		return a[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int peek() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		return a[top];
	}

	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		ArrayStackBasicOps arrayStackBasicOps = new ArrayStackBasicOps();
		System.out.println("Stack is Empty: " + arrayStackBasicOps.isEmpty());
		arrayStackBasicOps.push(4);
		arrayStackBasicOps.push(1);
		arrayStackBasicOps.push(7);
		arrayStackBasicOps.push(8);
		arrayStackBasicOps.push(2);
		arrayStackBasicOps.print();
	}

}
