package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/submissions/
public class GroupAnagramsFromList {

	public List<List<String>> groupAnagrams(String[] list) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < list.length; i++) {
			String str = list[i];
			String sortedStr = sortString(str);
			List<Integer> listOfIndexes = map.get(sortedStr);
			if (listOfIndexes == null)
				map.put(sortedStr, new ArrayList<>(Arrays.asList(i)));
			else
				listOfIndexes.add(i);
		}

		List<List<String>> result = new ArrayList<>();
		for (List<Integer> indexes : map.values()) {
			List<String> anagrams = new ArrayList<>();
			for (int i = 0; i < indexes.size(); i++) {
				anagrams.add(list[indexes.get(i)]);
			}
			result.add(anagrams);
		}
		return result;
	}

	private String sortString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
