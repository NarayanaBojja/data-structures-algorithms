package javaset;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Apple");
		linkedHashSet.add("Banana");
		linkedHashSet.add("Cherry");
		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int element : arr) {
			if (map.containsKey(element)) {
				map.put(element, map.get(element)+1);
			} else {
				map.put(element, 1);
			}
		}
		long count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

}
