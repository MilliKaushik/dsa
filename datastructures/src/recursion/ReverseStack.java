package recursion;

import java.util.Stack;

//https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9
public class ReverseStack {

	public void reverseStack(Stack<Integer> s) {
		if (s.size() == 0)
			return;
		int top = s.pop();
		reverseStack(s);
		insertAtLast(s, top);
	}

	private void insertAtLast(Stack<Integer> s, int top) {
		if (s.size() == 0) {
			s.push(top);
			return;
		}
		int curr = s.pop();
		insertAtLast(s, top);
		s.push(curr);
	}
}
