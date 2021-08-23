package array;

//https://app.codility.com/c/run/trainingDNKNMV-ZE4/
//https://stackoverflow.com/questions/19465965/java-codility-max-counters
public class MaxCounters {

	class Solution {
		public int[] solution(int n, int[] arr) {
			int maxSoFar = 0, lastUpdated = 0;
			int[] result = new int[n];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == n + 1)
					lastUpdated = maxSoFar;
				else {
					if (lastUpdated > result[arr[i] - 1])
						result[arr[i] - 1] = lastUpdated + 1;
					else
						result[arr[i] - 1]++;
					maxSoFar = Math.max(result[arr[i] - 1], maxSoFar);
				}
			}
			for (int i = 0; i < n; i++)
				if (result[i] < lastUpdated)
					result[i] = lastUpdated;
			return result;
		}
	}
}
