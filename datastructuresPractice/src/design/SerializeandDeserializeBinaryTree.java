package design;

import tree.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
public class SerializeandDeserializeBinaryTree {

	public static String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		preorder(root, str);
		return str.toString();
	}

	// Can we just append a character for null instead of the whole null string like
	// a #?
	private static void preorder(TreeNode root, StringBuilder str) {
		if (root == null) {
			// placeholder MIN_VALUE to represent null value - as it is given that values of
			// nodes will lie between -1000 to 1000
			str.append(intToString(Integer.MIN_VALUE));
			return;
		}
		str.append(intToString(root.val));
		preorder(root.left, str);
		preorder(root.right, str);
	}

	private static String intToString(int x) {
		char[] bytes = new char[4];
		for (int i = 3; i >= 0; i--)
			bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
		return new String(bytes);
	}

	static int preIndex = 0;

	public static TreeNode deserialize(String data) {
		int[] values = new int[data.length() / 4];
		for (int i = 0; i < data.length() / 4; i++)
			values[i] = stringToInt(data.substring(i * 4, i * 4 + 4));
		return constructTreeFromPreorder(values);
	}

	private static TreeNode constructTreeFromPreorder(int[] values) {
		if (preIndex == values.length)
			return null;
		if (values[preIndex] == Integer.MIN_VALUE) {
			preIndex++;
			return null;
		}
		TreeNode t = new TreeNode(values[preIndex]);
		preIndex++;
		t.left = constructTreeFromPreorder(values);
		t.right = constructTreeFromPreorder(values);
		return t;
	}

	private static Integer stringToInt(String a) {
		int k = 0;
		for (char c : a.toCharArray())
			k = (k << 8) + (int) c;
		return k;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.right.left = new TreeNode(4);
		t.right.right = new TreeNode(5);

		String output = serialize(t);
		TreeNode outputNode = deserialize(output);
		System.out.println(outputNode);
	}
}