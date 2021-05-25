package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		boolean leftFirst = true;
		List<List<Integer>> result = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currLevel = new ArrayList<>();
			if (leftFirst) {
				while (size-- != 0) {
					TreeNode node = queue.pollFirst();
					currLevel.add(node.val);
					if (node.left != null)
						queue.addLast(node.left);
					if (node.right != null)
						queue.addLast(node.right);
				}
			} else {
				while (size-- != 0) {
					TreeNode node = queue.pollLast();
					currLevel.add(node.val);
					if (node.right != null)
						queue.addFirst(node.right);
					if (node.left != null)
						queue.addFirst(node.left);
				}
			}
			result.add(currLevel);
			leftFirst = !leftFirst;
		}
		return result;
	}
}
