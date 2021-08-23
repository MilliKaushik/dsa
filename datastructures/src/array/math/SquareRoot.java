package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/819/
//https://www.geeksforgeeks.org/square-root-of-an-integer/
//use binary search to limit your integer search space
public class SquareRoot {

	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		long low = 1;
		long high = x / 2;
		long mid, result = 1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (mid * mid <= x) {
				result = mid;
				low = mid + 1;
			} else if (mid * mid > x)
				high = mid - 1;
		}
		return (int) result;
	}
}