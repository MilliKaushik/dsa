package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
public class BTLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int currLevelSize = queue.size();
			List<Integer> currLevelValues = new ArrayList<>();
			while (currLevelSize-- != 0) {
				TreeNode current = queue.remove();

				currLevelValues.add(current.val);

				if (current.left != null)
					queue.add(current.left);

				if (current.right != null)
					queue.add(current.right);
			}
			result.add(currLevelValues);
		}
		return result;
	}

	// Not implemented
	// https://www.geeksforgeeks.org/level-order-tree-traversal/
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		levelOrderHelper(root, result, height(root));
		return result;
	}

	private void levelOrderHelper(TreeNode root, List<List<Integer>> result, int height) {
		// TODO Auto-generated method stub
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
