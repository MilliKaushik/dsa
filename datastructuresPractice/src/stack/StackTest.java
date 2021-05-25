package stack;

import stack.stackapplications.ReverseWord;

public class StackTest {

	public static void main(String[] args) {
//		// StackUsingArrayBasic stackArr = new StackUsingArrayBasic(10);
//
//		Stack<Integer> stackArr = new ArrayStack<>(10);
////		System.out.println("Stack is empty : " + stackArr.isEmpty());
//		// System.out.println("Stack is full : " + stackArr.isFull());
//
//		// System.out.println("Popping : " + stackArr.pop());
//		System.out.println("Pushing : 1");
//		stackArr.push(1);
//
//		System.out.println("Pushing : 2");
//		stackArr.push(2);
//
//		System.out.println("Pushing : 3");
//		stackArr.push(3);
//
//		System.out.println("Pushing : 4");
//		stackArr.push(4);
//
//		// System.out.println("Peeking : " + stackArr.peek());
//
//		// System.out.println("Searching 2 : " + stackArr.search(2));
//
//		// System.out.println("Searching 1 : " + stackArr.search(1));
//
//		System.out.println("Size of stack : " + stackArr.size());
//
//		System.out.println("Popping : " + stackArr.pop());
//
//		System.out.println("Size of stack : " + stackArr.size());
//
//		System.out.println("Searching 2 : " + stackArr.search(2));
//
////		System.out.println("Size of stack : " + stackArr.size());
//
////		System.out.println("Searching 1 : " + stackArr.search(1));
//
//		System.out.println("Size of stack : " + stackArr.size());
//
//		System.out.println("Searching 4 : " + stackArr.search(4));

		ReverseWord reverseWord = new ReverseWord();

		System.out.println(reverseWord.reverse("AbcdEf"));
	}

}
