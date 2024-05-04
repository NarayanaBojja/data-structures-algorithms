package doubly;

class DoubleLinkedListNode {
	int val;
	DoubleLinkedListNode next;
	DoubleLinkedListNode prev;

	public DoubleLinkedListNode(int val) {
		this.val = val;
	}
}

class LRUCache {
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	private DoubleLinkedListNode temp;
	private int status;

	public LRUCache() {
		head = null;
		tail = null;
		temp = null;
		status = 0;
	}

	// Add a node to the cache
	public int addNode(int value) {
		if (head == null) {
			head = new DoubleLinkedListNode(value);
			tail = head;
			head.prev = null;
		} else {
			temp = tail;
			tail.next = new DoubleLinkedListNode(value);
			tail = tail.next;
			tail.prev = temp;
		}
		tail.next = null;
		return 0;
	}

	// Display the contents of the cache
	public int display() {
		if (head == null) {
			System.out.println("Add a node first");
			return -2;
		} else {
			temp = head;
			StringBuilder str = new StringBuilder();
			while (temp != null) {
				str.append("[").append(temp.val).append("]->");
				temp = temp.next;
			}
			System.out.println(str.toString() + "NULL");
		}
		return 0;
	}

	// Search for a value in the cache and update it as the most recently used
	public int searchCache(int value) {
		if (head == null) {
			System.out.println("Add a node first");
			return -1;
		}
		temp = head;
		while (temp != null) {
			if (temp.val == value) {
				while (temp != head) {
					temp.val = temp.prev.val;
					temp = temp.prev;
				}
				head.val = value;
				return 0;
			}
			temp = temp.next;
		}
		temp = tail.prev;
		while (temp != null) {
			temp.next.val = temp.val;
			temp = temp.prev;
		}
		head.val = value;
		return 0;
	}

	// Add a specified number of nodes to the cache
	public int numberOfNodes(int number) {
		for (int i = 0; i < number; i++) {
			status = addNode(0);
			if (status < 0) {
				System.out.println("Could not assign node");
				return status;
			}
		}
		return 0;
	}

	// Free the cache by removing all nodes
	public int freeCache() {
		temp = head;
		while (temp != null) {
			head = head.next;
			temp = head;
		}
		tail = null;
		return 0;
	}

	// Perform LRU operations on the cache using an array of values
	public void lruOp(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			status = searchCache(arr[i]);
			if (status < 0) {
				System.exit(1);
			}
			status = display();
		}
	}
}

public class LRUCacheUsingDL {
	public static void main(String[] args) {
		int MEMSIZE = 5;
		LRUCache cache = new LRUCache();
		cache.numberOfNodes(MEMSIZE);
		int n = 10;
		int[] arr = { 1, 2, 3, 4, 5, 2, 10, 7, 11, 1 };
		cache.lruOp(arr, n);
		cache.freeCache();
	}
}
