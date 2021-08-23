package array;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
//https://www.interviewbit.com/problems/3-sum/
//https://www.geeksforgeeks.org/find-a-triplet-in-an-array-whose-sum-is-closest-to-a-given-number/
//Using long to avoid integer overflow
public class ThreeSumClosestToTargetSum {

	public static int threeSumClosest(int[] arr, int x) {

		Arrays.sort(arr);
		long closestSum = arr[0] + arr[1] + arr[2];
		System.out.println("Closest sum : " + closestSum);

		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1, k = arr.length - 1;
			while (j < k) {

				// Possibility of integer overflow?
				long sum = arr[i] + arr[j] + arr[k];

				if (Math.abs(x - sum) < Math.abs(x - closestSum))
					closestSum = sum;

				if (sum > x)
					k--;
				else
					j++;
			}
		}
		return (int) closestSum;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { 2147483647, -2147483648, -2147483648, 0, 1 }, 0));
	}
}
