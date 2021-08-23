package stack.stackapplications;

import java.util.*;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/start/
public class FishUpstreamDownstream {

	public int solution(int[] a, int[] b) {
		Stack<Integer> stack = new Stack<>();
		int count = a.length;
		for (int i = a.length - 1; i >= 0; i--) {
			if (b[i] == 0)
				stack.push(i);
			else {
				while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
					count--;
					stack.pop();
				}
				if (!stack.isEmpty() && a[i] < a[stack.peek()])
					count--;
			}
		}
		return count;
	}
}
