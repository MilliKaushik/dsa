package stack.stackapplications;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://www.interviewbit.com/problems/redundant-braces/
public class RedundantBraces {

	public static int braces(String s) {
		Stack<Character> stack = new Stack<>();
		int i = 0;

		Set<Character> operators = new HashSet<>(Arrays.asList('*', '/', '+', '-'));
		Set<Character> openingBraces = new HashSet<>(Arrays.asList('(', '{', '['));
		Set<Character> closingBraces = new HashSet<>(Arrays.asList(')', '}', ']'));

		while (i < s.length()) {
			char c = s.charAt(i);
			if (operators.contains(c))
				stack.push(c);
			else if (openingBraces.contains(c))
				stack.push(c);
			else if (closingBraces.contains(c)) {
				if (!operators.contains(stack.peek()))
					return 1;
				stack.pop();
				stack.pop();
			}
			i++;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(braces("(())"));
		System.out.println(braces("(a)"));
		System.out.println(braces("(a + b)"));
		System.out.println(braces("((a + b))"));
		System.out.println(braces("(a + (a + b))"));
		System.out.println(braces("((a + b) + a)"));
	}

	// InterviewBit solution
	// We keep pushing elements onto the stack till we encounter ')'. When we do
	// encounter ')', we start popping elements till we
	// find a matching '('. If the number of elements popped do not correspond to
	// '()', we are fine and we can move forward.
	// Otherwise, voila! Matching braces have been found.
	public class Solution {
		public int braces(String a) {
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == '(' || a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*'
						|| a.charAt(i) == '/') {
					stack.push(a.charAt(i));
				} else if (a.charAt(i) == ')') {
					boolean didPopSymbol = false;
					while (stack.peek() != '(') {
						didPopSymbol = true;
						stack.pop();
					}
					if (!didPopSymbol)
						return 1;
					stack.pop();
				}
			}
			return 0;
		}
	}
}
