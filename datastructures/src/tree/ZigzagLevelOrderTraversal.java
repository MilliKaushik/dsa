package tree;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrderTraversal {

	private boolean leftFirst = true;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		return zigzagHelper(root, result);
	}

	private List<List<Integer>> zigzagHelper(TreeNode root, List<List<Integer>> result) {
		if (root != null) {

		}
		return null;
	}
}
