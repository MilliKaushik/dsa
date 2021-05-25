package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//Pick toys
//https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringwithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();
		int i = 0, j = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (i < n) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.size() > k) {
				while (map.size() > k) {
					char a = s.charAt(j);
					int count = map.get(a);
					if (count == 1)
						map.remove(a);
					else
						map.put(a, count - 1);
					j++;
				}
			}
			if (map.size() <= k)
				maxLen = Math.max(i - j + 1, maxLen);
			i++;
		}
		return maxLen;
	}
}
