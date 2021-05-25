package array.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/210/
//Solution : https://leetcode.com/problems/clone-graph/solution/
public class CloneGraph {
	public class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	private Map<Node, Node> visited = new HashMap<>();

	public Node cloneGraphDFS(Node node) {
		if (node == null)
			return node;
		if (visited.containsKey(node))
			return visited.get(node);

		Node clonedNode = new Node(node.val, new ArrayList<>());
		visited.put(node, clonedNode);

		for (Node orig : node.neighbors)
			clonedNode.neighbors.add(cloneGraphDFS(orig));
		return clonedNode;
	}

	public Node cloneGraphBFS(Node node) {
		if (node == null)
			return node;
		Map<Node, Node> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		visited.put(node, new Node(node.val, new ArrayList<>()));
		while (!queue.isEmpty()) {
			Node orig = queue.poll(); 
			for (Node n : orig.neighbors) {
				if (!visited.containsKey(n)) {
					visited.put(n, new Node(n.val, new ArrayList<>()));
					queue.add(n);
				}
				visited.get(orig).neighbors.add(visited.get(n));
			}
		}
		return visited.get(node);
	}
}
