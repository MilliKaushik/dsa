package design;

import java.util.HashMap;
import java.util.Map;

//using doubly licked list to store keys
//and map to store key and value
//Complexity O(n) - removeFromList complexity is O(n)
public class LRUCache1 {

	private class Node {
		private int val;
		private Node prev;
		private Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	private int capacity;
	private int size;
	private Map<Integer, Integer> cache;

	private Node head;
	private Node lastElement;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		size = 0;
		cache = new HashMap<>();
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			if (head != null && head.val != key) {
				removeFromList(key);
				putToHead(key);
			}
			return cache.get(key);
		} else
			return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			if (head != null && head.val != key) {
				removeFromList(key);
				putToHead(key);
			}
		} else {
			if (size == capacity) {
				int last = removeLastElement();
				cache.remove(last);
			}
			putToHead(key);
			size++;
		}
		cache.put(key, value);

	}

	private void putToHead(int key) {
		if (head == null) {
			head = new Node(key);
			lastElement = head;
		} else {
			Node curr = new Node(key);
			curr.next = head;
			head.prev = curr;
			head = curr;
		}
	}

	private void removeFromList(int key) {
		Node curr = head;
		while (curr != null) {
			if (curr.val == key) {
				if (curr == lastElement) {
					lastElement = lastElement.prev;
					if (lastElement == null) {
						head = null;
						return;
					}
					lastElement.next = null;
				} else {
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
					return;
				}
			}
			curr = curr.next;
		}
	}

	private int removeLastElement() {
		Node prev = lastElement.prev;
		int last = lastElement.val;
		lastElement = prev;
		if (prev != null)
			prev.next = null;
		size--;
		return last;
	}
}
