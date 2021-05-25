package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/818/
//Great explanation - https://stackoverflow.com/a/36996864/7786014
//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class Power {

	public double myPow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n < 0) {
			if (x == 0)
				throw new IllegalArgumentException("Cannot raise 0 to the power of a negative number");
			if (n == Integer.MIN_VALUE)
				return (1 / x) * (1 / myPow(x, Integer.MAX_VALUE));
			return 1 / myPow(x, -n);
		} else {
			double temp = myPow(x, n / 2);
			// checking for even number using bitwise
			// https://stackoverflow.com/questions/160930/how-do-i-check-if-an-integer-is-even-or-odd/161049
			// bitwise can depend on machine's representation of the number
			if ((n & 1) == 0)
				return temp * temp;
			else
				return temp * temp * x;
		}
	}
}