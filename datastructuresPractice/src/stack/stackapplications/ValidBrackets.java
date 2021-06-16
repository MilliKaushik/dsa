package stack.stackapplications;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/start/
public class ValidBrackets {

	public int solution(String S) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (map.keySet().contains(c))
				stack.push(map.get(c));
			else if (stack.isEmpty() || stack.pop() != c)
				return 0;
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
