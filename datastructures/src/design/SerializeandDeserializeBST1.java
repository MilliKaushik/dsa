package design;

import java.util.List;
import java.util.ArrayList;

import tree.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-bst/
public class SerializeandDeserializeBST1 {
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		postOrder(root, str);
		if (str.length() > 0)
			str.deleteCharAt(str.length() - 1);
		return str.toString();
	}

	private static void postOrder(TreeNode root, StringBuilder str) {
		if (root != null) {
			postOrder(root.left, str);
			postOrder(root.right, str);
			str.append(root.val);
			str.append(",");
		}
	}

	private static int postIndex = -1;

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;
		List<Integer> nodes = new ArrayList<>();
		for (String s : data.split(",")) {
			nodes.add(Integer.valueOf(s));
			postIndex++;
		}
		return deserializeHelper(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TreeNode deserializeHelper(List<Integer> nodes, int min, int max) {
		if (postIndex < 0 || nodes.get(postIndex) < min || nodes.get(postIndex) > max)
			return null;
		TreeNode root = new TreeNode(nodes.get(postIndex));
		postIndex--;
		root.right = deserializeHelper(nodes, root.val, max);
		root.left = deserializeHelper(nodes, min, root.val);
		return root;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(2);
		t.left = new TreeNode(1);
		t.right = new TreeNode(3);

		System.out.println(serialize(t));
		System.out.println(deserialize("1,3,2"));
	}
}
