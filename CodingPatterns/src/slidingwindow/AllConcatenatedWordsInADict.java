package slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConcatenatedWordsInADict {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		if (words.length == 0 || words[0].length() == 0) {
			return List.of();
		}
		Map<String, Integer> wordsFrequency = new HashMap<>();
		for (String word : words) {
			if (wordsFrequency.containsKey(word)) {
				wordsFrequency.put(word, 0);
			} else {
				wordsFrequency.put(word, wordsFrequency.get(word) + 1);
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
