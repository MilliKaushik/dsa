package array.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//https://www.youtube.com/watch?v=bGC2fNALbNU
//https://www.techiedelight.com/generate-power-set-given-set/
//https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
public class PowerSet {

	// https://www.youtube.com/watch?v=bGC2fNALbNU
	public void printSubset(int[] num) {
		printSubsetHelper(num, new Integer[num.length], 0);
	}

	private void printSubsetHelper(int[] num, Integer[] subset, int i) {
		if (i == num.length) {
			System.out.println(Arrays.toString(subset));	
			return;
		}
		subset[i] = null;
		printSubsetHelper(num, subset, i + 1);
		subset[i] = num[i];
		printSubsetHelper(num, subset, i + 1);
	}

//https://www.techiedelight.com/generate-power-set-given-set/
	public void generateSubset(int[] num) {
		generateSubsetHelper(num, new ArrayDeque<Integer>(), num.length - 1);
	}

	private void generateSubsetHelper(int[] num, Deque<Integer> list, int i) {
		if (i < 0) {
			System.out.println(list);
			return;
		}
		list.addLast(num[i]);
		generateSubsetHelper(num, list, i - 1);

		list.removeLast();
		generateSubsetHelper(num, list, i - 1);
	}
}
