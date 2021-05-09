package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://javarevisited.blogspot.com/2017/08/how-to-remove-key-value-pair-from-map-iteration-java-example.html#axzz6uFjdZlEg
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty())
			return 0;
		int maxLength = Integer.MIN_VALUE;
		int len = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int oldIndex = map.get(c);
				Set<Entry<Character, Integer>> setOfEntries = map.entrySet();
				Iterator<Entry<Character, Integer>> iterator = setOfEntries.iterator();
				while (iterator.hasNext()) {
					Entry<Character, Integer> entry = iterator.next();
					if (entry.getValue() < oldIndex)
						iterator.remove();
				}
				map.put(c, i);
				maxLength = Math.max(len, maxLength);
				len = i - oldIndex;
			} else {
				map.put(c, i);
				len++;
			}
		}
		return Math.max(len, maxLength);
	}
}
