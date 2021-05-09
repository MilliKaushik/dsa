package array.sort;

public class MergeSort {

	public void sort(int[] num) {
		mergeSort(num, 0, num.length - 1);
	}

	private void mergeSort(int[] num, int st, int end) {
		if (st >= end)
			return;
		int m = (st + end) / 2;
		mergeSort(num, st, m);
		mergeSort(num, m + 1, end);
		merge(num, st, end, m);
	}

	private void merge(int[] num, int st, int end, int m) {
		int n1 = m - st + 1;
		int n2 = end - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++)
			L[i] = num[st + i];

		for (int j = 0; j < n2; j++)
			R[j] = num[m + j + 1];

		int i = 0;
		int j = 0;
		int k = st;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j])
				num[k++] = L[i++];
			else
				num[k++] = R[j++];
		}
		while (i < n1)
			num[k++] = L[i++];
		while (j < n2)
			num[k++] = R[j++];
	}
}
