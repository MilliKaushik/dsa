package design;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
//https://leetcode.com/explore/interview/card/top-interview-questions-hard/122/design/867/
//Both get and put are in O(1) time
public class LRUCache2 {
	private int capacity, size;
	private Map<Integer, Node> cache;
	private Node head, tail;

	private class Node {
		private int key;
		private int value;
		private Node prev;
		private Node next;

		private Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		size = 0;
		cache = new HashMap<>();
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			if (head != null && head.key != key) {
				Node node = cache.get(key);
				deleteNode(node);
				addToHead(node);
			}
			return cache.get(key).value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.value = value;
			if (head != null && head.key != key) {
				deleteNode(node);
				addToHead(node);
			}
		} else {
			Node node = new Node(key, value);
			cache.put(key, node);
			if (size < capacity)
				size++;
			else {
				Node toBeRemoved = tail;
				deleteNode(tail);
				cache.remove(toBeRemoved.key);
			}
			addToHead(node);
		}
	}

	private void deleteNode(Node node) {
		if (head == node) {
			head = head.next;
			if (head != null)
				head.prev = null;
			if (tail == node)
				tail = head;
		} else {
			node.prev.next = node.next;
			if (node == tail) {
				tail = node.prev;
			} else
				node.next.prev = node.prev;
			node.prev = null;
		}
	}

	private void addToHead(Node node) {
		if (head == null) {
			head = tail = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
		}
	}
}
