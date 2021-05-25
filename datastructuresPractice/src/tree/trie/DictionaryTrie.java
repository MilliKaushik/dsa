package tree.trie;

public class DictionaryTrie {

	private static final int ALPHABET_SIZE = 26;

	private class TrieNode {
		private boolean isEndOfWordFlag;
		private TrieNode[] children;
		private String meaning;

		public TrieNode() {
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	TrieNode root;

	public void insert(String key, String meaning) {
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
		node.meaning = meaning;
	}
}
