package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BinaryTree {

	private TreeNode first, second, prev;

	public void printInorder(TreeNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);
	}

	// https://www.interviewbit.com/problems/inorder-traversal/
	public ArrayList<Integer> inorder(TreeNode root) {
		ArrayList<Integer> inorderList = new ArrayList<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		TreeNode current = root;
		if (root == null)
			return inorderList;
		while (current != null || !nodeStack.isEmpty()) {
			while (current != null) {
				nodeStack.push(current);
				current = current.left;
			}
			current = nodeStack.pop();
			inorderList.add(current.val);
			current = current.right;
		}
		return inorderList;
	}

	// 12
	// 10 11 -1
// -1  20  

	// https://www.interviewbit.com/problems/recover-binary-search-tree/
	// variables except root passed to correctbstutil can also be declared as class
	// memeber variable
	public ArrayList<Integer> correctBST(TreeNode root) {
		first = second = prev = null;
		correctBSTUtil(root);

		return new ArrayList<>(Arrays.asList(second.val, first.val));
	}

	private void correctBSTUtil(TreeNode current) {
		if (current == null)
			return;
		correctBSTUtil(current.left);
		if (prev != null && current.val < prev.val) {
			if (first == null)
				first = prev;
			second = current;
		}
		prev = current;
		correctBSTUtil(current.right);
	}

	// https://www.geeksforgeeks.org/cartesian-tree-from-inorder-traversal-segment-tree/
	public TreeNode buildTree(ArrayList<Integer> A) {
		ArrayList<Integer> nodesList = A;
		int start = 0;
		int end = nodesList.size() - 1;
		return constructTree(nodesList, start, end);
	}

	private TreeNode constructTree(ArrayList<Integer> nodesList, int start, int end) {
		if (start > end)
			return null;

		int maxIndex = maxInorder(nodesList, start, end);
		TreeNode root = new TreeNode(nodesList.get(maxIndex));

		root.left = constructTree(nodesList, start, maxIndex - 1);
		root.right = constructTree(nodesList, maxIndex + 1, end);
		return root;
	}

	private int maxInorder(ArrayList<Integer> nodesList, int start, int end) {
		int maxIndex = start;
		for (int i = start + 1; i <= end; i++) {
			if (nodesList.get(i) > nodesList.get(maxIndex))
				maxIndex = i;
		}
		return maxIndex;
	}

}
