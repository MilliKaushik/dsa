package array;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/859/
public class MedianTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int mid = (m + n) / 2;
		int i = 0, j = 0, prev = -1;
		boolean istotalNoEven = ((m + n) % 2 == 0) ? true : false;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				if (mid == 0)
					return medianFound(nums1, nums1[i], prev, istotalNoEven);
				prev = nums1[i++];
			} else {
				if (mid == 0)
					return medianFound(nums2, nums2[j], prev, istotalNoEven);
				prev = nums2[j++];
			}
			mid--;
		}
		while (i < m) {
			if (mid == 0)
				return medianFound(nums1, nums1[i], prev, istotalNoEven);
			prev = nums1[i++];
			mid--;
		}
		while (j < n) {
			if (mid == 0)
				return medianFound(nums2, nums2[j], prev, istotalNoEven);
			prev = nums2[j++];
			mid--;
		}
		return -1;
	}

	private double medianFound(int[] arr, int i, int j, boolean totalNoEven) {
		if (!totalNoEven) {
			return i;
		} else {
			return (double) (i + j) / 2;
		}
	}
}
