package array;

//https://www.geeksforgeeks.org/array-rotation/
//https://leetcode.com/problems/rotate-array/
//https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/start/
public class RotateArrayByK {

	// right rotation
	// for left rotation : (0, k - 1), (k , n - 1), (0 , n - 1)
	// Let AB are the two parts of the input array where A = arr[0..d-1] and B =
	// arr[d..n-1]. The idea of the algorithm is :
	// Reverse A to get ArB, where Ar is reverse of A.
	// Reverse B to get ArBr, where Br is reverse of B.
	// Reverse all to get (ArBr) r = BA.
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		if (k == 0)
			return;
		while (k > n)
			k = k % n;
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
	}

	private void reverse(int[] nums, int st, int end) {
		while (st < end) {
			int temp = nums[st];
			nums[st] = nums[end];
			nums[end] = temp;
			st++;
			end--;
		}
	}

	public void rotate1(int[] nums, int k) {
		int n = nums.length;
		if (k == 0)
			return;
		if (k > n)
			k %= n;
		for (int i = 0; i < k; i++)
			rightRotateByOne(nums);
	}

	private void rightRotateByOne(int[] nums) {
		int n = nums.length;
		int temp = nums[n - 1];
		for (int i = n - 1; i > 0; i--)
			nums[i] = nums[i - 1];
		nums[0] = temp;
	}

	// https://www.geeksforgeeks.org/array-rotation/
	// Method 2
	// METHOD 1 (Using temp array)
//Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
//1) Store the first d elements in a temp array
	// temp[] = [1, 2]
//2) Shift rest of the arr[]
	// arr[] = [3, 4, 5, 6, 7, 6, 7]
//3) Store back the d elements
	// arr[] = [3, 4, 5, 6, 7, 1, 2]

	// Method 3
	// METHOD 2 (Rotate one by one)
//leftRotate(arr[], d, n)
//start
	// For i = 0 to i < d
	// Left rotate all elements of arr[] by one
//end
}
