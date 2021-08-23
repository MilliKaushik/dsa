package array;

import java.util.*;

//https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/start/
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
	
	public int solution2(int x, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int k = Math.abs(arr[i]);
			if (k <= arr.length && arr[k - 1] > 0) {
				arr[k - 1] = -arr[k - 1];
				count++;
				if (count == x)
					return i;
			}
		}
		if(count == x)
			return count;
		return -1;
	}

//wrong solution
	public int solution3(int x, int[] arr) {
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
