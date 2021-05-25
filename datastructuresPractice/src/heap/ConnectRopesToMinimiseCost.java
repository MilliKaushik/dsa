package heap;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class ConnectRopesToMinimiseCost {

	public long minCost(long arr[], int n) {
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++)
			minHeap.add(arr[i]);

		long sum = 0;
		// another condition can be if size >= 2 or not and if not it wont enter the
		// loop and just return the sum
		while (!minHeap.isEmpty()) {
			long firstCost = minHeap.remove();
			if (minHeap.isEmpty())
				return sum;
			long secondCost = minHeap.remove();
			long totalCost = firstCost + secondCost;
			sum += totalCost;
			minHeap.add(totalCost);
		}
		return sum;
	}
}
