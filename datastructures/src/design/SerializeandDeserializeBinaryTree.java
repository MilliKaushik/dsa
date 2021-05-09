package design;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/812/
public class SerializeandDeserializeBinaryTree {
	private static final char OPEN_BKT = '[';
	private static final char CLOSE_BKT = ']';
	private static final String NULL = "null";
	private static final char COMMA = ',';

	public String serialize(TreeNode root) {
		StringBuffer str = new StringBuffer();
		str.append(OPEN_BKT);
		if (root != null)
			str.append(String.valueOf(root.val));

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- != 0) {
				TreeNode t = queue.remove();
				String currVal = t != null ? String.valueOf(t.val) : NULL;
				str.append(currVal);
				str.append(COMMA);
				TreeNode left = t.left != null ? t.left : null;
				queue.add(left);
				TreeNode right = t.right != null ? t.right : null;
				queue.add(right);
			}
		}
		// removing last comma
		str.deleteCharAt(str.length() - 1);
		str.append(CLOSE_BKT);
		return str.toString();
	}

	public TreeNode deserialize(String data) {
		TreeNode root = null, prev = null;
		StringBuffer str = new StringBuffer();
		boolean isLeftSet = false;
		boolean isRightSet = false;
		int i = 1;
		while (true) {
			while (i < data.length() - 1 && (data.charAt(i) != COMMA)) {
				str.append(data.charAt(i));
				i++;
			}
			if (str.equals(NULL)) {
				if (!isLeftSet)
					isLeftSet = true;
				isRightSet = false;
				continue;
			}
			int val = Integer.parseInt(str.toString());
			TreeNode node = new TreeNode(val);
			if (root == null) {
				root = node;
				prev = root;
				isLeftSet = false;
			} else {
				if (!isLeftSet)
					root.left = node;
				else {
					root.right = node;
					if (root.left != null)
						root = root.left;
					else
						root = root.right;
				}
			}
			if (i == data.length())
				break;
			// to take care of comma
			i++;
		}
		return root;
	}
}