package array;

import java.util.HashMap;
import java.util.Map;

//https://app.codility.com/c/run/trainingHEQFY7-WFX/

public class GenomicRangeQueryUNSOLVED {

	public int[] solution(String s, int[] p, int[] q) {
		int[] result = new int[p.length];
		int min;
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);
		for (int j = 0; j < p.length; j++) {
			int x = p[j];
			int y = q[j];
			min = map.get(s.charAt(x));
			for (int i = x + 1; i <= y; i++) {
				min = Math.min(map.get(s.charAt(i)), min);
				if (min == 1)
					break;
			}
			result[j] = min;
		}
		return result;
	}
}
