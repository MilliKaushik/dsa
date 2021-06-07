package array;

import java.util.*;

//https://app.codility.com/c/run/trainingRPUE2V-PT4/
public class FrogRiverOne {

	public int solution1(int x, int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= x; i++)
			set.add(i);
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i]))
				set.remove(arr[i]);
			if (set.isEmpty())
				return i;
		}
		return -1;
	}

//wrong solution
	public int solution2(int x, int[] arr) {
		int xor = 1;
		for (int i = 2; i <= x; i++)
			xor ^= i;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;
			xor ^= arr[i];
			arr[arr[i] - 1] = 0;
			if (xor == 0)
				return i;
		}
		return -1;
	}
}
