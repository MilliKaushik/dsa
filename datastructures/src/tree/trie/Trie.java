package tree.trie;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/122/design/868/
public class Trie {

	private static final int ALPHABET_SIZE = 26;

	private class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		boolean isEndOfWordFlag;

		public TrieNode() {
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
			isEndOfWordFlag = false;
		}
	}

	private TrieNode root;

	public void insert(String key) {
		if (root == null)
			root = new TrieNode();
		TrieNode node = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (node.children[index] == null)
				node.children[index] = new TrieNode();
			node = node.children[index];
		}
		node.isEndOfWordFlag = true;
	}

	public boolean search(String key) {
		TrieNode node = root;
		if (node == null)
			return false;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (node.children[index] == null)
				return false;
			node = node.children[index];
		}
		return (node != null && node.isEndOfWordFlag);
	}
}
