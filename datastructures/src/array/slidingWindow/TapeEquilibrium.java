package array.slidingWindow;

//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public class TapeEquilibrium {

	public int solution(int[] arr) {
		int n = arr.length;
		int first = 0, second = 0;
		for (int i = 0; i < n; i++)
			second += arr[i];
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			first += arr[i];
			second -= arr[i];
			minDiff = Math.min(Math.abs(first - second), minDiff);
		}
		return minDiff;
	}
}
