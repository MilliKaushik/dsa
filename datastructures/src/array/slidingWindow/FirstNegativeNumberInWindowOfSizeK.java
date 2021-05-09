package array.slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
public class FirstNegativeNumberInWindowOfSizeK {

	// what if no negative number in the given window? Can we print 0?
	public ArrayList<Integer> findFirstNegative(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		// lifo needed
		Queue<Integer> negativeNumbers = new LinkedList<>();
		int i = 0, j = 0;
		while (j < arr.length) {
			if (arr[i] < 0)
				negativeNumbers.add(arr[i]);
			if (j - i + 1 == k) {
				if (negativeNumbers.size() == 0)
					result.add(0);
				else {
					result.add(negativeNumbers.peek());
					if (arr[i] == negativeNumbers.peek())
						negativeNumbers.remove();
				}
				i++;
			} else if (j - i + 1 < k)
				j++;
		}
		return result;
	}
}
