package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/4sum-ii/
public class FourSum2 {

	public static void main(String[] args) {
		System.out.println(
				fourSumCount(new int[] { -1, -1 }, new int[] { -1, 1 }, new int[] { -1, 1 }, new int[] { 1, -1 }));
	}

	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int sum = nums1[i] + nums2[j];
				List<List<Integer>> list = null;
				if (map.containsKey(sum))
					list = map.get(sum);
				else
					list = new ArrayList<>();
				list.add(Arrays.asList(i, j));
				map.put(sum, list);
			}
		}

		int count = 0;
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				int sum = nums3[i] + nums4[j];
				if (map.containsKey(-sum))
					count += map.get(-sum).size();
			}
		}
		return count;
	}
}
