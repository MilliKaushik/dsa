package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://www.interviewbit.com/problems/4-sum/
//https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
public class FourSum {

	private static class Element {
		private int index1;
		private int index2;

		public Element(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}
	}

	public static ArrayList<ArrayList<Integer>> fourSum(List<Integer> arr, int target) {
		Set<Set<Integer>> result = new HashSet<>();
		Map<Integer, Element> sumMap = new HashMap<>();
		for (int i = 0; i < arr.size(); i++)
			for (int j = i + 1; j < arr.size(); j++)
				sumMap.put(arr.get(i) + arr.get(j), new Element(i, j));

		for (int sum : sumMap.keySet()) {
			if (sumMap.containsKey(target - sum)) {
				Element ele1 = sumMap.get(sum);
				Element ele2 = sumMap.get(target - sum);
				if (ele1.index1 == ele2.index1 || ele1.index1 == ele2.index2 || ele1.index2 == ele2.index1
						|| ele1.index2 == ele2.index2)
					continue;
				Set<Integer> sumSet = new HashSet<>();
				sumSet.add(arr.get(ele1.index1));
				sumSet.add(arr.get(ele1.index2));
				sumSet.add(arr.get(ele2.index1));
				sumSet.add(arr.get(ele2.index2));
				if (result.contains(sumSet))
					continue;
				Collections.sort(new ArrayList<>(sumSet));
				result.add(sumSet);
				System.out.println(result);
			}
		}
		// Collections.sort(Arrays.asList(result), new ListComparator());
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		System.out.println(fourSum(Arrays.asList(5, 4, 2, 8, 3), 19));

		System.out.println(fourSum(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9,
				-2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7,
				6, -4, 2, 0, 10, 1, -2, 5, -2), 0));
	}

	private static class ListComparator implements Comparator<ArrayList<Integer>> {

		@Override
		public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
			int x1 = Integer.compare(arr1.get(0), arr2.get(0));
			if (x1 != 0)
				return x1;
			int x2 = Integer.compare(arr1.get(1), arr2.get(1));
			if (x2 != 0)
				return x2;
			int x3 = Integer.compare(arr1.get(2), arr2.get(2));
			if (x3 != 0)
				return x3;
			int x4 = Integer.compare(arr1.get(3), arr2.get(3));
			if (x4 != 0)
				return x4;
			return 0;
		}
	}
}
