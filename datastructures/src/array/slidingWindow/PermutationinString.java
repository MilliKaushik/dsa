package array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/
public class PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		int n = s2.length();
		int k = s1.length();
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int count = map.size();
		while (i < n) {
			char c = s2.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) - 1);
			if (map.get(c) != null && map.get(c) == 0)
				count--;
			if (i - j + 1 == k) {
				if (count == 0)
					return true;
				char a = s2.charAt(j);
				if (map.containsKey(a)) {
					if (map.get(a) != null && map.get(a).equals(0))
						count++;
					map.put(a, map.getOrDefault(a, 0) + 1);
				}
				j++;
			}
			i++;
		}
		return false;
	}
}
