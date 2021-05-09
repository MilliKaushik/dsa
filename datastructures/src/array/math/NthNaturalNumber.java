package array.math;

//https://practice.geeksforgeeks.org/problems/nth-natural-number/1
public class NthNaturalNumber {
	public long findNth(long N) {
		boolean hasNine = ifNHasNine(N);
		long quotient = N / 10;
		long result = N + quotient;
		while (ifNHasNine(result))
			result += 1L;
		return result;
	}

	private boolean ifNHasNine(long n) {
		while (n != 0) {
			if (n % 10 == 9)
				return true;
			n /= 10;
		}
		return false;
	}
}
