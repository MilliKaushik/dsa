package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/
//https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1
public class FactorialZeroes {

	public int trailingZeroes(int n) {
		int a = 5;
		int count = 0;
		int power = 1;
		while (n >= a) {
			count += n / a;
			a = (int) Math.pow(5, ++power);
		}
		return count;
	}
}
