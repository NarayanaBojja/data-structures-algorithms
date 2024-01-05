package string;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MaxOccuringChar {

	public static void main(String[] args) {
		String str = "output";
		System.out.println(getMaxOccuringChar(str));
	}

	public static char getMaxOccuringChar(String line) {
		Map<Character, Integer> map = new TreeMap<>();
		int count = 0;
		char ans = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (count < map.get(ch)) {
				ans = ch;
				count = map.get(ch);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if (val == count && key < ans) {
				ans = key;
			}
		}
		return ans;

	}
}
