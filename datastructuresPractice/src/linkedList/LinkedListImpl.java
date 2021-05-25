package linkedList;

public class LinkedListImpl<E> {

	private class Node {
		private E value;
		private Node next;

		public Node(E value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node : [ value->" + value + ", next->" + next + "]";
		}
	}

	Node head;
	Node tail;
	int size;
	
	
	public void addFirst(E value) {
		Node newNode = new Node(value);
		if(isEmpty())
			head = tail = newNode;
		else {
			newNode.next = head.next;
			
		}
		size++;
	}

	public void addLast(E value) {
		Node newNode = new Node(value);

		if (isEmpty())
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	

	private boolean isEmpty() {
		return head == null;
	}

}
