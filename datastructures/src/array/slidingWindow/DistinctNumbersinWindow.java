package array.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.interviewbit.com/problems/distinct-numbers-in-window/
public class DistinctNumbersinWindow {

	public static ArrayList<Integer> dNums(List<Integer> arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (k > arr.size())
			return result;
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0, j = 0;
		while (i < arr.size()) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
			if (i - j + 1 == k) {
				result.add(map.size());
				int prevWindowElement = arr.get(j);
				if (map.get(prevWindowElement) == 1)
					map.remove(prevWindowElement);
				else
					map.put(prevWindowElement, map.get(prevWindowElement) - 1);
				j++;
			}
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(dNums(Arrays.asList(1), 1));
		System.out.println(dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3));
		System.out.println(dNums(Arrays.asList(1, 1, 2, 2), 1));
	}
}
