package tree;

//https://www.geeksforgeeks.org/deletion-binary-tree/
public class DeletionInBT {

	private TreeNode parentOfNodeToBeDeleted;

	private int count = 1;

	public TreeNode deletionBT(TreeNode root, int key) {
		TreeNode keyNode = findKeyNode(root, key);
		if (keyNode == null)
			return root;
		int size = sizeOfTree(root);
		parentOfNodeToBeDeleted = root;
		TreeNode nodeToBeDeleted = preOrder(root, size);
		parentOfNodeToBeDeleted.right = null;
		keyNode.val = nodeToBeDeleted.val;
		return root;
	}

	private int sizeOfTree(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
	}

	private TreeNode findKeyNode(TreeNode root, int key) {
		if (root != null) {
			if (root.val == key)
				return root;
			TreeNode left = findKeyNode(root.left, key);
			if (left != null)
				return left;
			return findKeyNode(root.right, key);
		}
		return null;
	}

	private TreeNode preOrder(TreeNode root, int size) {
		if (root == null)
			return null;
		if (size == count)
			return root;
		parentOfNodeToBeDeleted = root;
		TreeNode left = preOrder(root.left, size);
		if (left != null)
			return left;
		return preOrder(root.right, size);
	}
}
