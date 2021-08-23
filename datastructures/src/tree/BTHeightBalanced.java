package tree;

//https://www.interviewbit.com/problems/balanced-binary-tree/
//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class BTHeightBalanced {

	private class Height {
		int height;

		public Height() {
			height = 0;
		}
	}

	public int isBalanced(TreeNode root, Height height) {
		if (root == null) {
			height.height = 0;
			return 1;
		}

		Height leftHt = new Height();
		Height rightHt = new Height();

		int isLeftBalanced = isBalanced(root.left, leftHt);
		int isRightBalanced = isBalanced(root.right, rightHt);

		if (Math.abs(leftHt.height - rightHt.height) > 1)
			return 0;

		height.height = Math.max(leftHt.height, rightHt.height) + 1;
		if (isLeftBalanced == 0)
			return 0;
		return isRightBalanced;
	}

}
