package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//CHECK
public class CountOccurrencesOfAnagram {

	public int countAnagrams(String s1, String s2) {
		int countDistinctLetters = 0;
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0;
		int k = s2.length();
		for (int t = 0; t < k; t++) {
			Character ch = s2.charAt(t);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		countDistinctLetters = map.keySet().size();
		int ans = 0;
		while (j < s1.length()) {
			char ch = s1.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					countDistinctLetters--;
			} else if (j - i + 1 == k) {
				if (countDistinctLetters == 0)
					ans++;
				if (map.containsKey(s1.charAt(i))) {
					map.put(s1.charAt(i), map.get(s1.charAt(i) + 1));
					if (map.get(s1.charAt(i)) == 1)
						countDistinctLetters++;
				}
				i++;
			}
			j++;
		}
		return ans;
	}
}
