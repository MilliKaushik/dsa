package array.math;

//https://practice.geeksforgeeks.org/problems/add-two-fractions/1
// Not done this - https://leetcode.com/problems/fraction-addition-and-subtraction/
public class AddFractions {

	public int[] addFraction(int[] frac1, int[] frac2) {
		int num1 = frac1[0];
		int num2 = frac2[0];

		int den1 = frac1[1];
		int den2 = frac2[1];

		int lcm = (den1 / hcf(den1, den2)) * den2;

		int resultNum = (lcm / den1) * num1 + (lcm / den2) * num2;
		int resultDen = lcm;
		return lowest(resultNum, resultDen);
	}

	private int hcf(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a > b)
			return hcf(a - b, b);
		return hcf(a, b - a);
	}

	private int[] lowest(int num1, int num2) {
		int commonFactor = hcf(num1, num2);
		num1 /= commonFactor;
		num2 /= commonFactor;
		int[] result = new int[2];
		result[0] = num1;
		result[1] = num2;
		return result;
	}
}
