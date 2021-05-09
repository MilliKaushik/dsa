package tree;

import java.util.ArrayList;


//SOME ERROR
//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
public class BinaryTreeInorderPreorderConstruct {
	static int preIndex = 0;

	public void printInorder(TreeNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);
	}

	public TreeNode constructFromInorderPreorder(ArrayList<Integer> in, ArrayList<Integer> pre) {
		return constructTree(in, pre, 0, pre.size() - 1);
	}

	private TreeNode constructTree(ArrayList<Integer> in, ArrayList<Integer> pre, int startIn, int endIn) {
		if (startIn > endIn)
			return null;

		TreeNode root = new TreeNode(pre.get(preIndex++));
		if (startIn == endIn)
			return root;

		int inorderIndex = searchInorder(in, root.val);
		root.left = constructTree(in, pre, startIn, inorderIndex - 1);
		root.right = constructTree(in, pre, inorderIndex + 1, endIn);
		return root;
	}

	private int searchInorder(ArrayList<Integer> in, Integer element) {
		return in.indexOf(element);
	}
}
