package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AllCOPY {

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int min = -1;
		while (i < a.size()) {
			if (stack.isEmpty())
				result.add(min);
			else if (stack.peek() < a.get(i))
				result.add(stack.peek());
			else {
				while (!stack.isEmpty() && stack.peek() >= a.get(i))
					stack.pop();
				if (stack.isEmpty())
					result.add(min);
				else
					result.add(stack.peek());
			}
			stack.push(a.get(i));
			i++;
		}
		return result;
	}

	private class Node {
		private int key, value;
		private Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Map<Integer, Node> cache;
	private Node head, tail;

	public AllCOPY(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		moveToHead(key);
		return cache.get(key).value;
	}

	public void set(int key, int value) {
		if (!cache.containsKey(key)) {
			if (capacity == cache.size()) {
				if (head != tail) {
					tail.prev.next = null;
					cache.remove(tail.key);
					tail = tail.prev;
				} else if (head == tail) {
					cache.remove(head.key);
					head = tail = null;
				}
			}
			cache.put(key, new Node(key, value));
		} else if (cache.containsKey(key)) {
			Node curr = cache.get(key);
			curr.value = value;
		}
		moveToHead(key);
	}

	private void moveToHead(int key) {
		if (head == null) {
			head = tail = cache.get(key);
			return;
		} else if (head.key == key)
			return;

		Node curr = cache.get(key);
		if (curr == tail)
			tail = curr.prev;
		// fix nodes next and prev to current
		if (curr.prev != null)
			curr.prev.next = curr.next;
		if (curr.next != null)
			curr.next.prev = curr.prev;
		// move current to head position
		curr.next = head;
		curr.prev = null;
		head.prev = curr;
		head = curr;
	}

	public static void main(String[] args) {

	}
}
