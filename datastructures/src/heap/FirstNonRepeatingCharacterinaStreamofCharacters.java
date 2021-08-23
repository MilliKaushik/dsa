package heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
public class FirstNonRepeatingCharacterinaStreamofCharacters {

	// O(n) - array and map both space complexity
	// O(n2) time complexity
	// we can do better than this by using an array of 26 size instead of of n size
	// as we only need a marker to check if this character was visited
	public static String solve1(String s) {
		if (s.length() == 0)
			return "";

		StringBuilder str = new StringBuilder();
		char[] arr = new char[s.length()];
		Map<Character, Integer> map = new HashMap<>();
		int lastIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c) && map.get(c) != -1) {
				arr[map.get(c)] = '$';
				map.put(c, -1);
			} else if (!map.containsKey(c)) {
				lastIndex++;
				arr[lastIndex] = c;
				map.put(c, lastIndex);
			}

			int j = 0;
			for (; j <= lastIndex; j++)
				if (arr[j] != '$') {
					str.append(arr[j]);
					break;
				}
			if (j == lastIndex + 1)
				str.append('#');
		}
		return str.toString();
	}

	public static String solve2(String s) {
		StringBuilder str = new StringBuilder();
		if (s.isEmpty())
			return "";
		int[] map = new int[26];
		for (int i = 0; i < 26; i++)
			map[i] = 0;
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c - 'a'] += 1;
			queue.add(c);
			char b = '#';
			while (!queue.isEmpty()) {
				if (map[queue.peek() - 'a'] == 1) {
					b = queue.peek();
					break;
				} else
					queue.remove();
			}
			str.append(b);
		}

		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(solve2("abadbc"));
		System.out.println(solve2("abcabc"));
		System.out.println(solve2("abcdcdbac"));
		System.out.println(solve2("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
	}
}
