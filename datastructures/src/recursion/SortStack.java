package recursion;

import java.util.Stack;

//https://www.youtube.com/watch?v=MOGBRkkOhkY&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=7
//https://practice.geeksforgeeks.org/problems/sort-a-stack/1
public class SortStack {
	public Stack<Integer> sort(Stack<Integer> s) {
		if (s.isEmpty() || s.size() == 1)
			return s;
		int top = s.pop();
		sort(s);
		insert(s, top);
		return s;
	}

	private void insert(Stack<Integer> s, int top) {
		if (s.isEmpty() || s.peek() <= top) {
			s.push(top);
			return;
		}
		int current = s.pop();
		insert(s, top);
		s.push(current);
	}
}
