package queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://www.geeksforgeeks.org/lru-cache-implementation/#lru-cache-implementation-using-queue-and-hashing
 * 
 */
public class LRUCache {
	// store keys of cache
	private Deque<Integer> doublyQueue;
	// store references of key in cache
	private HashSet<Integer> hashSet;
	private final int CACHE_SIZE;

	LRUCache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	public void refer(int data) {
		if (!hashSet.contains(data)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		} else {
			doublyQueue.remove(data);
		}
		doublyQueue.push(data);
		hashSet.add(data);
	}

	public void display() {
		doublyQueue.forEach(data -> {
			System.out.print(data + " ");
		});
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.display();
	}

}
