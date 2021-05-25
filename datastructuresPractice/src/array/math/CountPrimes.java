package array.math;

//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
public class CountPrimes {

	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++)
			isPrime[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j <= n; j += i)
				isPrime[j] = false;
		}
		int count = 0;
		for (int i = 2; i < n; i++)
			if (isPrime[i])
				count++;
		return count;
	}
}
