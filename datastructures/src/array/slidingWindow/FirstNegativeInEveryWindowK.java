package array.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeInEveryWindowK {

	public int[] firstNegative(int[] arr, int k) {
		int n = arr.length;
		int[] result = new int[n - k + 1];
		int i = 0, j = 0;
		int a = 0;
		Queue<Integer> queue = new LinkedList<>();
		while (i < n) {
			if (arr[i] < 0)
				queue.add(i);
			if (i - j + 1 == k) {
				while (!queue.isEmpty() && queue.peek() < j)
					queue.remove();
				if (!queue.isEmpty())
					result[a++] = arr[queue.peek()];
				else
					result[a++] = 0;
				j++;
			}
			i++;
		}
		return result;
	}
}
