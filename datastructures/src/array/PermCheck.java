package array;

//https://app.codility.com/c/run/trainingZ6P3E5-6AC/
public class PermCheck {

	class Solution {
		public int solution(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > arr.length)
					return 0;
				int current = arr[i] < 0 ? arr[i] * -1 : arr[i];
				if (arr[current - 1] < 0)
					return 0;
				arr[current - 1] *= -1;
			}
			return 1;
		}
	}
}
