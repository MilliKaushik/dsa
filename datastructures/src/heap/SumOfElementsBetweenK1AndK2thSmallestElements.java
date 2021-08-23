package heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=3ioQQQrnw4Q&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=11
public class SumOfElementsBetweenK1AndK2thSmallestElements {

	// assuming k1 and k2 to be within range
	// duplicates??
	public static long sumBetweenTwoKth(long arr[], long n, long k1, long k2) {
		int n1 = arr.length;
		long k1SmallestElement = findKthSmallestElement(arr, k1);
		long k2SmallestElement = findKthSmallestElement(arr, k2);
		long sum = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > k1SmallestElement && arr[i] < k2SmallestElement)
				sum += arr[i];
		return sum;
	}

	private static long findKthSmallestElement(long[] arr, long k) {
		// if we used a private class Element
		// not used Collections.reverseOrder because here we are adding a custom class
		// and we can implement compareTo method in a way that does descending sort
		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k)
				maxHeap.remove();
		}
		return maxHeap.peek();
	}
}
