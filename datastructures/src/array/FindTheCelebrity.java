package array;

import java.util.Stack;
import binarySearch.FindCountFirstAndLastOccurrenceSortedArray;

//https://www.geeksforgeeks.org/the-celebrity-problem/
//https://leetcode.com/explore/interview/card/microsoft/48/others/194/
public class FindTheCelebrity {

	// O(n2) time and O(n) space complexity
	public int findCelebrity1(int n) {
		boolean isCandidate[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			isCandidate[i] = false;
			int countWhoKnowsMe = 0;
			for (int j = 0; j < n; j++) {
				if (i != j && knows(j, i) && !knows(i, j)) {
					countWhoKnowsMe++;
				}
			}
			if (countWhoKnowsMe == n - 1)
				isCandidate[i] = true;
		}

		for (int i = 0; i < n; i++)
			if (isCandidate[i])
				return i;
		return -1;
	}

	// O(n) space and O(n) time complexity - 2(n - 1) comparisons are done while
	// traversing through stack as for every pair(there are n - 1 pairs), two
	// comparisons are done
	// n more comparisons are done when confirming if this indeed is the celebrity
	public int findCelebrity2(int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++)
			stack.push(i);

		while (!stack.isEmpty() && stack.size() >= 2) {
			int a = stack.pop();
			int b = stack.pop();
			boolean aKnowsb = knows(a, b);
			boolean bKnowsa = knows(b, a);
			if (!aKnowsb && bKnowsa)
				stack.push(a);
			if (!bKnowsa && aKnowsb)
				stack.push(b);
		}
		if (stack.isEmpty())
			return -1;
		int candidate = stack.pop();
		for (int i = 0; i < n; i++)
			if (i != candidate && (!knows(i, candidate) || knows(candidate, i)))
				return -1;

		return candidate;
	}

	// O(n) time and O(1) space - 3(n - 1) comparisons
	public int findCelebrity3(int n) {
		int i = 0, j = n - 1;
		while (i < j) {
			boolean iKnowsj = knows(i, j);
			if (iKnowsj)
				i++;
			else if (!iKnowsj)
				j--;
		}
		for (int k = 0; k < n; k++)
			if (k != i && (!knows(k, i) || knows(i, k)))
				return -1;
		return j;
	}

	// Recursion - O(n) time and O(1) space
	public int findCelebrity4(int n) {
		int possibleCandidate = findCelebrity4Helper(n);
		if (possibleCandidate == -1)
			return -1;
		for (int i = 0; i < n; i++)
			if (possibleCandidate != i && (knows(possibleCandidate, i) || !knows(i, possibleCandidate)))
				return -1;
		return possibleCandidate;
	}

	private int findCelebrity4Helper(int n) {
		if (n == 0)
			return -1;
		int candidate = findCelebrity4Helper(n - 1);
		if (candidate == -1)
			return n - 1;
		if (knows(candidate, n - 1))
			return n - 1;
		if (knows(n - 1, candidate))
			return candidate;
		return -1;
	}

	private boolean knows(int a, int b) {
		int[][] graph = { { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 1 } };
		if (graph[a][b] == 1)
			return true;
		return false;
	}
}
