package datastructrePractice.practice;

import java.util.Arrays;

public class Microsoft1 {

	public int solution(int[] arr) {
		int n = arr.length;

		// sorting the array to reach calculate the middle element in sorted array
		Arrays.sort(arr);

		int mid = arr[n / 2];

		int stepCount = calculateStepCount(arr, mid);

		// if the number of elements is even, there are two middle elements so we will
		// calculate the number of steps needed for each of them and take the minimum of
		// those two values
		if (n % 2 == 0) {
			mid = arr[n / 2 - 1];
			int currentStepCount = calculateStepCount(arr, mid);

			stepCount = Math.min(currentStepCount, stepCount);
		}
		return stepCount;
	}

	// calculating the minimum steps to reach the target value for each element of
	// the array
	private int calculateStepCount(int[] arr, int targetValue) {
		int n = arr.length;
		int stepCount = 0;
		for (int i = 0; i < n; i++)
			stepCount += Math.abs(targetValue - arr[i]);
		return stepCount;
	}
}
