package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		inorderTraversalHelper(root, inorder);
		return inorder;
	}

	private void inorderTraversalHelper(TreeNode root, List<Integer> inorder) {
		if (root == null)
			return;
		inorderTraversalHelper(root.left, inorder);
		inorder.add(root.val);
		inorderTraversalHelper(root.right, inorder);
	}

	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				while (root.left != null) {
					stack.push(root.left);
					root = root.left;
				}
			}
			TreeNode top = stack.pop();
			inorder.add(top.val);
			if (top != null)
				root = top.right;
		}
		return inorder;
	}
}
