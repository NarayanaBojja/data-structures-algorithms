package javaset;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(5);
		set.add(1);
		set.add(3);
		set.add(4);
		set.add(6);
		System.out.println(set.isEmpty() + " " + set.size());
		set.remove(6);
		set.forEach(obj -> {
			System.out.println(obj);
		});
	}

}
