package array.slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://javarevisited.blogspot.com/2017/08/how-to-remove-key-value-pair-from-map-iteration-java-example.html#axzz6uFjdZlEg
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstringWithSW(String s) {
		int n = s.length();
		int i = 0, j = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (i < n) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.size() < i - j + 1) {
				while (map.size() < i - j + 1) {
					char d = s.charAt(j);
					int count = map.get(d);
					if (count == 1)
						map.remove(d);
					else
						map.put(d, count - 1);
					j++;
				}
			}
			if (map.size() == i - j + 1)
				maxLen = Math.max(i - j + 1, maxLen);
			i++;
		}
		return maxLen;
	}

	public int lengthOfLongestSubstringWithoutSW(String s) {
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
