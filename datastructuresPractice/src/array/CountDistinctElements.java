package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/6-sorting/distinct/start/
public class CountDistinctElements {

	public int solution1(int[] a) {
		int count = 0;
		int n = a.length;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			count++;
			while (i < n - 1 && a[i] == a[i + 1])
				i++;
		}
		return count;
	}

	public int solution2(int[] a) {
		int count = 0;
		int n = a.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			if (set.add(a[i]))
				count++;
		return count;
	}
}
