package array;

//https://www.interviewbit.com/problems/first-missing-integer/
//https://app.codility.com/c/run/training4JKDZ9-T28/
public class FirstMissingInteger {

	public int firstMissingPositive(int[] arr) {
		int index = segregate(arr);
		for (int i = 0; i < index; i++) {
			int x = Math.abs(arr[i]);
			if (x <= index && arr[x - 1] > 0)
				arr[x - 1] *= -1;
		}

		for (int i = 0; i < index; i++)
			if (arr[i] > 0)
				return i + 1;
		return index + 1;
	}

	private int segregate(int[] arr) {
		int n = arr.length;
		int i = 0, j = n - 1;
		while (i <= j) {
			if (arr[j] <= 0) {
				j--;
				continue;
			}
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}
			i++;
		}
		if (j == n - 1 && arr[j] > 0)
			return n;
		if (j == -1)
			return 0;
		if (arr[j] <= 0)
			return j;
		else
			return j + 1;
	}
}
