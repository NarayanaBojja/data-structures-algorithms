package queue;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

	private int capacity;
	private HashMap<Integer, Integer> values;
	private HashMap<Integer, Integer> frequencies;
	private LinkedHashSet<Integer> keys;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		values = new HashMap<>();
		frequencies = new HashMap<>();
		keys = new LinkedHashSet<>();
	}

	public int get(int key) {
		if (!values.containsKey(key)) {
			return -1;
		}

		int frequency = frequencies.get(key);
		frequencies.put(key, frequency + 1);
		keys.remove(key);
		keys.add(key);

		return values.get(key);
	}

	public void put(int key, int value) {
		if (capacity <= 0) {
			return;
		}

		if (values.containsKey(key)) {
			int frequency = frequencies.get(key);
			frequencies.put(key, frequency + 1);
			keys.remove(key);
			keys.add(key);
			values.put(key, value);
			return;
		}

		if (values.size() >= capacity) {
			int leastFrequentKey = keys.iterator().next();
			keys.remove(leastFrequentKey);
			values.remove(leastFrequentKey);
			frequencies.remove(leastFrequentKey);
		}

		values.put(key, value);
		frequencies.put(key, 1);
		keys.add(key);
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		
		System.out.println(cache.get(1)); // 1
		System.out.println(cache.get(2)); // 2
		System.out.println(cache.get(3)); // 3

		

		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 2
		System.out.println(cache.get(3)); // 3
		System.out.println(cache.get(4)); // 4
	}
}
