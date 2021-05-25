package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//Trie can also be used but I felt it is less space efficient overall. We anyway do sorting so Time complexity is O(nmlogm) + extra space that trie uses plus if we store list of indexes in a trienode 
//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
//https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
public class GroupAnagramsCOPY {

	public List<List<String>> groupAnagramsSorting(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String sortedStr = sort(strs[i]);
			if (map.containsKey(sortedStr)) {
				List<String> values = map.get(sortedStr);
				values.add(strs[i]);
				map.put(sortedStr, values);
			} else
				map.put(sortedStr, new ArrayList<>(Arrays.asList(strs[i])));
		}
		List<List<String>> result = new ArrayList<>();
		for (Entry<String, List<String>> entry : map.entrySet())
			result.add(entry.getValue());

		return result;
	}

	private String sort(String string) {
		int m = string.length();
		Character[] arr = new Character[m];
		for (int i = 0; i < m; i++)
			arr[i] = string.charAt(i);
		Arrays.sort(arr, new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return Character.compare(c1, c2);
			}
		});
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < m; i++)
			str.append(arr[i]);
		return str.toString();
	}
}
