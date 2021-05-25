package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
public class LongestSubstringWithKUniqueCharacters {

	public int longestkSubstr(String s, int k) {
		int n = s.length();
		int i = 0, j = 0, maxLen = -1;
		Map<Character, Integer> map = new HashMap<>();
		while (i < n) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.size() > k) {
				while (map.size() > k) {
					char b = s.charAt(j);
					int count = map.get(b);
					if (count == 1)
						map.remove(b);
					else
						map.put(b, count - 1);
					j++;
				}
			}
			if (map.size() == k)
				maxLen = Math.max(i - j + 1, maxLen);
			i++;
		}
		return maxLen;
	}
}
