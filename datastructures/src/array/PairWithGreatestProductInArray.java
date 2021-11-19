package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/
public class PairWithGreatestProductInArray {

	public static int findGreatest(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
				if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
					if (arr[j] == arr[i] / arr[j] && map.get(arr[i] / arr[j]) > 1)
						return arr[i];
					else if (arr[j] != arr[i] / arr[j])
						return arr[i];
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 25 };
		int n = arr.length;

		System.out.println(findGreatest(arr, n));
	}

}
