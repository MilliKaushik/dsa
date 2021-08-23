package stack.stackapplications;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/823/
public class ReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		Set<String> operands = new HashSet<>(Arrays.asList(new String[] { "/", "*", "+", "-" }));
		for (int i = 0; i < tokens.length; i++) {
			if (operands.contains(tokens[i])) {
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				int result = operate(tokens[i], first, second);
				stack.push(String.valueOf(result));
			} else
				stack.push(tokens[i]);
		}
		return Integer.parseInt(stack.pop());
	}

	private int operate(String operand, int first, int second) {
		int result = -1;
		switch (operand) {
		case "/":
			result = first / second;
			break;
		case "*":
			result = first * second;
			break;
		case "+":
			result = first + second;
			break;
		case "-":
			result = first - second;
			break;
		}
		return result;
	}
}
