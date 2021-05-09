package array.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
public class IntersectionofTwoArrays {
	public int[] intersect(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		Map<Integer, Integer> nums1ToCount = new HashMap<>();
		for (int i = 0; i < m; i++) {
			if (nums1ToCount.containsKey(nums1[i])) {
				int count = nums1ToCount.get(nums1[i]);
				nums1ToCount.put(nums1[i], ++count);
			} else
				nums1ToCount.put(nums1[i], 1);
		}
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			if (nums1ToCount.containsKey(nums2[j])) {
				int count = nums1ToCount.get(nums2[j]);
				if (count > 1)
					nums1ToCount.put(nums2[j], --count);
				else
					nums1ToCount.remove(nums2[j]);
				list.add(nums2[j]);
			}
		}
		int k = 0;
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			result[k++] = list.get(i);
		return result;
	}
}
