package linkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> {

	private class Node {
		private E value;
		private Node next;

		public Node(E value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}

	}

	private Node head;
	private Node tail;
	private int size;

	// addFirst
	// addLast
	// deleteFirst
	// deleteLast
	// containsOf
	// indexOf

	public void addFirst(E item) {
		Node newNode = new Node(item);

		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void addLast(E item) {
		Node newNode = new Node(item);

		if (isEmpty())
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node node = head;
		head = head.next;
		node.next = null;
		size--;
	}

	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node node = head;
		if (head == tail) {
			head = tail = null;
		} else {
			node = getPrevious(tail);
			node.next = null;
			tail = node;
		}
		size--;
	}

	private Node getPrevious(Node node) {
		while (node != null) {
			if (node.next == tail)
				break;
			node = node.next;
		}
		return node;
	}

	public boolean containsOf(E item) {
		return indexOf(item) != -1;
	}

	public int indexOf(E item) {
		if (isEmpty())
			return -1;
		int index = 0;
		Node node = head;
		while (node != null) {
			if ((E) node.value == item)
				return index;
			node = node.next;
			index++;
		}
		return -1;
	}

	public void removeKthFromEnd(int k) {
		if(k <= 0)
			throw new IllegalArgumentException();
		Node slow = head;
		Node fast = head;
		while (k != 0 && fast != null && fast.next != null) {
			fast = fast.next;
		}
		
		if(fast == null)
			throw new IllegalArgumentException();

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		if (slow == head) {
			head = head.next;
			slow.next = null;
		}
		Node nextNext = slow.next.next;
		Node next = slow.next;
		slow.next = nextNext;
		next.next = null;
	}

	public void reverse() {
		Node current = head;
		Node next = head;
		Node previous = null;

		while (current != null) {
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}
		head = tail;
		tail = head;
	}

	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		int index = 0;
		Node node = head;
		while (node != null) {
			array[index++] = node.value;
			node = node.next;
		}
		return array;
	}

	// O(1)
	public int size() {
		return size;
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}

	private boolean isEmpty() {
		return head == null;
	}

}
