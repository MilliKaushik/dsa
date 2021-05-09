package array.orderStatistics;

public class ThreeLargestElementInArray {

	public void threeLargest(int[] num) {
		int[] threeMax = new int[3];
		for (int i = 0; i < 3; i++) {
			threeMax[i] = num[i];
		}
		sort(threeMax);
		for (int i = 3; i < num.length; i++) {
			if (threeMax[0] < num[i])
				swap(threeMax[0], num[i]);
		}
	}

	private void swap(int first, int second) {
		int temp = first;
		first = second;
		second = temp;
	}

	// merge sort implemented
	private void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int st, int end) {
		if (st < end) {
			int m = (st + end) / 2;
			mergeSort(arr, st, m);
			mergeSort(arr, m + 1, end);
			merge(arr, st, end, m);
		}
	}

	private void merge(int[] arr, int st, int end, int m) {
		int n1 = m - st + 1;
		int n2 = end - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++)
			L[i] = arr[st + i];
		for (int j = 0; j < n2; j++)
			R[j] = arr[m + j + 1];
		int i = 0, j = 0;
		int k = st;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		}
		while (i < n1)
			arr[k++] = L[i++];
		while (j < n2)
			arr[k++] = R[j++];
	}
}
