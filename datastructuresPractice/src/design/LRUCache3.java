package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {
	private int capacity, size;
	private LinkedHashMap<Integer, Node> cache;
	private Node head, tail;

	private class Node {
		private int key, value;
		private Node prev, next;

		private Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUCache3(int capacity) {
		this.capacity = capacity;
		size = 0;
		cache = new LinkedHashMap<>() {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size > capacity;
			}
		};
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			;
		} else {
			;

		}
	}

}
