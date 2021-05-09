package array.math;

//https://leetcode.com/problems/power-of-three/submissions/
public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
		if (n == 0)
			return false;
		// n = 1 is a power of 3 as three to power 0 is 1
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}
}
