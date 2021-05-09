package tree;

import java.util.ArrayList;
import java.util.Stack;

//https://www.interviewbit.com/problems/preorder-traversal/ - Recursive not working
public class BinaryTreePreorderTraversal {
	static ArrayList<Integer> preArray = new ArrayList<>();

	public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
		preorderUtil(root);

		return preArray;
	}

	private void preorderUtil(TreeNode root) {
		if (root == null)
			return;
		preArray.add(root.val);
		preorderUtil(root.left);
		preorderUtil(root.right);
	}

	public ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> preArray = new ArrayList<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			TreeNode current = nodeStack.pop();
			preArray.add(current.val);
			if (current.right != null)
				nodeStack.push(current.right);
			if (current.left != null)
				nodeStack.push(current.left);
		}

		return preArray;
	}
}