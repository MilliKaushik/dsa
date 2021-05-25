package recursion;

import java.util.Stack;

//https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8
public class DeleteMddleElementInStack {

	public Stack<Integer> deleteMiddle(Stack<Integer> s) {
		if(s.size() == 0)
			return s;
		return deleteMiddleHelper(s, s.size() / 2 + 1);
	}

	private Stack<Integer> deleteMiddleHelper(Stack<Integer> s, int k) {
		if (s.size() == 0)
			return null;
		if (s.size() == 1) {
			s.pop();
			return s;
		}
		int top = s.pop();
		deleteMiddleHelper(s, k - 1);
		s.push(top);
		return s;
	}
}
