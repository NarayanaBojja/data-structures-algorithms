package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * time complexity is 𝑂 ( 𝑛 ⋅ 𝑘 ), Space Complexity: 𝑂 ( 𝑛 ⋅ 𝑘 ) Find
 * unique words in an array of words containing anagrams
 */
public class UniqueWordsInAnagrams {
	public static List<String> findUniqueWords(String[] words) {
		Map<String, String> uniqueWordsMap = new HashMap<>();

		for (String word : words) {
			int[] charCount = new int[26]; // Assuming only lowercase letters a-z
			for (char c : word.toCharArray()) {
				charCount[c - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int count : charCount) {
				sb.append('#'); // To separate counts of different letters
				sb.append(count);
			}
			String canonicalForm = sb.toString();
			uniqueWordsMap.putIfAbsent(canonicalForm, word);
		}

		return new ArrayList<>(uniqueWordsMap.values());
	}

	public static void main(String[] args) {
		String[] words = { "listen", "silent", "enlist", "google", "gooegl", "abc", "cab" };
		List<String> uniqueWords = findUniqueWords(words);
		System.out.println("Unique words: " + uniqueWords);
	}
}
