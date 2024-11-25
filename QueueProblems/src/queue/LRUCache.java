package queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * LRUCache class implements a simple Least Recently Used (LRU) Cache using a
 * {@link Deque} for storage and a {@link HashSet} for quick lookups.
 * 
 * Key operations: - `refer`: Adds a new reference to the cache and maintains
 * LRU policy. - `display`: Displays the current cache contents.
 * 
 * Time Complexity: - `refer`: O(1) for checking the set, O(1) for deque
 * operations. - `display`: O(N), where N is the size of the cache.
 * 
 * Space Complexity: - O(C), where C is the cache capacity, for the deque and
 * hash set.
 */
public class LRUCache {
	private final Deque<Integer> doublyQueue; // Stores keys of the cache in LRU order
	private final HashSet<Integer> hashSet; // Stores references of keys for fast lookup
	private final int CACHE_SIZE; // Maximum capacity of the cache

	/**
	 * Constructor to initialize the LRU Cache with a specified capacity.
	 * 
	 * @param capacity The maximum number of items the cache can hold.
	 */
	public LRUCache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	/**
	 * Refers a new data item to the cache. - If the data is not in the cache: -
	 * Removes the least recently used item if the cache is full. - Adds the new
	 * data to the front of the deque and updates the hash set. - If the data is
	 * already in the cache: - Removes it from its current position in the deque. -
	 * Moves it to the front of the deque (most recently used position).
	 * 
	 * @param data The data to refer.
	 * 
	 *             Time Complexity: O(1) - Checking the hash set: O(1). -
	 *             Adding/removing from deque: O(1).
	 * 
	 *             Space Complexity: O(1) additional space, as operations modify
	 *             existing structures.
	 */
	public void refer(int data) {
		if (!hashSet.contains(data)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast(); // Remove least recently used item
				hashSet.remove(last); // Update hash set
			}
		} else {
			doublyQueue.remove(data); // Remove the data from its current position
		}
		doublyQueue.push(data); // Add the new/updated data to the front of the deque
		hashSet.add(data); // Update hash set
	}

	/**
	 * Displays the contents of the cache in LRU order.
	 * 
	 * Time Complexity: O(N) - Iterates through the deque to display its contents.
	 * 
	 * Space Complexity: O(1), no additional data structures are used.
	 */
	public void display() {
		doublyQueue.forEach(data -> {
			System.out.print(data + " ");
		});
	}

	/**
	 * Main method to demonstrate the functionality of the LRUCache.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);

		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);

		// Expected output: 5 4 1 3
		cache.display();
	}
}
