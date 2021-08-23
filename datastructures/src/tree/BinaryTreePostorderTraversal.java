package tree;

import java.util.ArrayList;
import java.util.Stack;

//https://www.interviewbit.com/problems/postorder-traversal/
public class BinaryTreePostorderTraversal {

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
