package array.math;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/java-program-for-efficiently-print-all-prime-factors-of-a-given-number/
//https://practice.geeksforgeeks.org/problems/largest-prime-factor2601/1
public class PrintPrimeFactors {

	public long getPrimeFactors(int n) {
		List<Integer> primeFactors = new ArrayList<>();
		int largestPrimeFactor = Integer.MIN_VALUE;
		while (n % 2 == 0) {
			primeFactors.add(2);
			n /= 2;
			largestPrimeFactor = 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i++)
			while (n % i == 0) {
				primeFactors.add(i);
				n /= i;
				largestPrimeFactor = i;
			}

		if (n > 2) {
			primeFactors.add(n);
			largestPrimeFactor = n;
		}
		return largestPrimeFactor;
	}
}
