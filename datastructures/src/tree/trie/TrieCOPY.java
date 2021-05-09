package tree.trie;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/122/design/868/
public class TrieCOPY {
	TrieNode root;

	public TrieCOPY() {
		root = new TrieNode();
	}

	private final int ALPHABET_SIZE = 26;

	private class TrieNode {

		private TrieNode[] children;
		private boolean isEndOfWordFlag;

		private TrieNode() {
			children = new TrieNode[ALPHABET_SIZE];
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
				isEndOfWordFlag = false;
			}
		}
	}

	public void insert(String word) {
		if (root == null)
			root = new TrieNode();
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.children[index] == null)
				node.children[index] = new TrieNode();
			node = node.children[index];
		}
		node.isEndOfWordFlag = true;
	}

	public boolean search(String word) {
		if (root == null)
			return false;
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.children[index] == null)
				return false;
			node = node.children[index];
		}
		return node.isEndOfWordFlag;
	}

	public boolean startsWith(String prefix) {
		if (root == null)
			return false;
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (node.children[index] == null)
				return false;
			node = node.children[index];
		}
		return true;
	}
}
