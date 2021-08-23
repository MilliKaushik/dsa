package design;

import java.util.ArrayDeque;

import tree.TreeNode;

//https://leetcode.com/problems/serialize-and-deserialize-bst/solution/
//https://www.baeldung.com/java-and-0xff
//https://leetcode.com/problems/serialize-and-deserialize-bst/

//Interesting read - https://www.javamex.com/tutorials/memory/string_memory_usage.shtml
//Interesting read - https://www.infoworld.com/article/2077496/java-tip-130--do-you-know-your-data-size-.html

//Lets suppose the tree is 12345 -> right-> 12346 -> right -> 12347
//In this case, using approach 1, we end up using 2 bytes per character for every String which means 
//12355(5 * 2), so finally 30 bytes for the three node values and 2 bytes per delimiter, so finally 
//34 bytes. We can do better than this as an integer in Java is stored using 4 bytes - further would 
//be getting rid of the delimiters.
//If we use bytes array, we use 4 bytes per node value and 2 bytes per delimiter. So finally, 18 bytes of memory.
//It's not only that though, as string also uses some extra bytes to store other info but for simplicity sake. (Read article above)
public class SerializeandDeserializeBST2 {
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		postOrder(root, str);
		return str.toString();
	}

	private static void postOrder(TreeNode root, StringBuilder str) {
		if (root != null) {
			postOrder(root.left, str);
			postOrder(root.right, str);
			str.append(intToString(root.val));
			// no need for delimiter as we know each set of 4 bytes forms one integer
		}
	}

	// If we simply convert 12345 to a string, we use 5 * 2 bytes of memory. If we
	// convert 12345 to a bytes array which will use 4 bytes to store the integer,
	// we end using less memory.
	private static String intToString(int x) {
		char[] bytes = new char[4];
		for (int i = 3; i >= 0; i--)
			// no of times to be shifted so that last 8 bits are in focus. We shift by 8
			// bits to the right every time to get the next set of 8 bits
			bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
		return new String(bytes);
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;

		ArrayDeque<Integer> nodes = new ArrayDeque<>();
		for (int i = 0; i < data.length() / 4; i++)
			nodes.add(stringToInt(data.substring(i * 4, i * 4 + 4)));

		return deserializeHelper(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static int stringToInt(String x) {
		int k = 0;
		for (char c : x.toCharArray())
			k = (k << 8) + (int) c;
		return k;
	}

	private static TreeNode deserializeHelper(ArrayDeque<Integer> nodes, int min, int max) {
		if (nodes.isEmpty())
			return null;
		int nums = nodes.getLast();
		if (nums < min || nums > max)
			return null;
		TreeNode root = new TreeNode(nums);
		nodes.removeLast();
		root.right = deserializeHelper(nodes, root.val, max);
		root.left = deserializeHelper(nodes, min, root.val);
		return root;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(2);
		t.left = new TreeNode(1);
		t.right = new TreeNode(3);

		String output = serialize(t);
		System.out.println(deserialize(output));
	}
}
