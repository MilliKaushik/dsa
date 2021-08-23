package array.sort;

//https://www.geeksforgeeks.org/java-program-for-quicksort/?ref=rp
public class QuickSort {

	void quickSort(int[] num, int low, int high) {
		if (low < high) {
			int pi = partition(num, low, high);
			quickSort(num, low, pi - 1);
			quickSort(num, pi + 1, high);
		}
	}

	private int partition(int[] num, int low, int high) {
		int pivot = num[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (num[j] <= pivot) {
				i++;
				swap(num[i], num[j]);
			}
		}
		swap(num[i + 1], num[high]);
		return i + 1;
	}

	private void swap(int num1, int num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;

	}
}
