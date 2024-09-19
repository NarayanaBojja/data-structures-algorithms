package doubly;

import java.util.HashMap;

public class LRUCache {
	private class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int capacity;
	private final HashMap<Integer, Node> map;
	private final Node head;
	private final Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(0, 0); // Dummy head
		this.tail = new Node(0, 0); // Dummy tail
		head.next = tail;
		tail.prev = head;
	}

	private void addNode(Node node) {
		Node temp = head.next;
		head.next = node;
		node.prev = head;
		node.next = temp;
		temp.prev = node;
	}

	private void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private Node popTail() {
		Node res = tail.prev;
		removeNode(res);
		return res;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1; // Not found
		}
		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {
				Node tailNode = popTail();
				map.remove(tailNode.key);
			}
			addNode(newNode);
			map.put(key, newNode);
		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1); // cache is {1=1}
		cache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}
}
