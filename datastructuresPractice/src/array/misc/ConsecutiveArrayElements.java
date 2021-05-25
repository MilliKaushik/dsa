package array.misc;

//https://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
public class ConsecutiveArrayElements {

	// correct
	public boolean areConsecutiveAP(long[] num, int N) {
		int n = num.length;
		long min = num[0], max = num[0];
		long arraySum = num[0];
		for (int i = 1; i < n; i++) {
			arraySum += num[i];
			min = Math.min(num[i], min);
			max = Math.max(num[i], max);
		}
		long apSum = max * (max + 1) / 2 - min * (min + 1) / 2 + min;
		return arraySum == apSum;
	}

	// incorrect - check why
	public boolean areConsecutives(long num[], int N) {
		int n = num.length;
		long min = num[0], max = num[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(num[i], min);
			max = Math.max(num[i], max);
		}
		if (max - min != n - 1)
			return false;

		for (int i = 0; i < n; i++) {
			long current = num[i] < 0 ? num[i] * -1 : num[i];
			long j = (int) (current - min);
			if (j < 0)
				return false;
			num[(int) j] *= -1;
		}
		for (int i = 0; i < n; i++)
			if (num[i] > 0)
				return false;
		return true;
	}

}
