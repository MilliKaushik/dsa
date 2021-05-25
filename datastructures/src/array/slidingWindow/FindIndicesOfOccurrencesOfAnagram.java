package array.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindIndicesOfOccurrencesOfAnagram {

	// space optimized
	// count maintains size of map, if all characters become 0, count becomes 0.
	public List<Integer> findAnagrams1(String s, String p) {
		List<Integer> indices = new ArrayList<>();
		if (p.length() > s.length())
			return indices;
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int a = 0; a < p.length(); a++)
			map.put(p.charAt(a), map.getOrDefault(p.charAt(a), 0) + 1);
		int count = map.size();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) - 1);
			if (map.get(c) != null && map.get(c).equals(0))
				count--;
			if (i - j + 1 == p.length()) {
				if (count == 0)
					indices.add(j);
				// removing the previous window character
				char prevChar = s.charAt(j);
				if (map.containsKey(prevChar)) {
					// should this be 1?
					if (map.get(prevChar).equals(0))
						count++;
					map.put(prevChar, (map.get(prevChar)) + 1);
				}
				j++;
			}
			i++;
		}
		return indices;
	}

	// Not space optimized. We use two maps. O(k + plength) solution
	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> indices = new ArrayList<>();
		if (p.length() > s.length())
			return indices;
		int i = 0, j = 0;
		Map<Character, Integer> angmCnt = new HashMap<>();
		for (int a = 0; a < p.length(); a++)
			angmCnt.put(p.charAt(a), angmCnt.getOrDefault(p.charAt(a), 0) + 1);
		Map<Character, Integer> winCnt = new HashMap<>();
		while (i < s.length()) {
			char c = s.charAt(i);
			winCnt.put(c, winCnt.getOrDefault(c, 0) + 1);
			if (i - j + 1 == p.length()) {
				if (areSameMap(winCnt, angmCnt))
					indices.add(j);
				// removing the previous window character
				int count = winCnt.get(s.charAt(j));
				if (count == 1)
					winCnt.remove(s.charAt(j));
				else
					winCnt.put(s.charAt(j), --count);
				j++;
			}
			i++;
		}
		return indices;
	}

	private boolean areSameMap(Map<Character, Integer> windowCharCnt, Map<Character, Integer> anagramCharCnt) {
		Set<Character> windowKey = windowCharCnt.keySet();
		Set<Character> anagramKey = anagramCharCnt.keySet();
		if (!windowKey.equals(anagramKey))
			return false;
		for (char c : anagramKey)
			if (!anagramCharCnt.get(c).equals(windowCharCnt.get(c)))
				return false;
		return true;
	}
}
