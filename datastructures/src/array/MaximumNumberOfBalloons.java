package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/maximum-number-of-balloons/
public class MaximumNumberOfBalloons {

	public int maxNumberOfBalloons(String text) {
		String balloon = "balloon";
		Set<Character> doubleChar = new HashSet<>();
		doubleChar.add('l');
		doubleChar.add('o');

		Set<Character> singleChar = new HashSet<>();
		singleChar.add('b');
		singleChar.add('a');
		singleChar.add('n');

		Map<Character, Integer> map = new HashMap<>();
		int n = text.length();
		for (int i = 0; i < n; i++) {
			char ch = text.charAt(i);
			if (singleChar.contains(ch) || doubleChar.contains(ch))
				map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		if (map.size() < balloon.length() - 2)
			return 0;
		int minSingle = Integer.MAX_VALUE;
		int minDouble = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (doubleChar.contains(entry.getKey()))
				minDouble = Math.min(entry.getValue(), minDouble);
			else
				minSingle = Math.min(entry.getValue(), minSingle);
		}
		if (minSingle == 0 || minDouble <= 1)
			return 0;
		return Math.min(minSingle, minDouble / 2);
	}
}
