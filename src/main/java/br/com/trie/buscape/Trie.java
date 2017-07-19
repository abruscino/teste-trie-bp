package br.com.trie.buscape;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word != null) {
			TrieNode p = root;
			String wordLowerCase = word.toLowerCase();
			for (int i = 0; i < wordLowerCase.length(); i++) {
				char c = wordLowerCase.charAt(i);
				int index = c - 'a';
				if (p.getArr()[index] == null) {
					TrieNode temp = new TrieNode();
					p.getArr()[index] = temp;
					p = temp;
					System.out.println("New node " + c);
				} else {
					p = p.getArr()[index];
				}
			}
			p.setLeaf(Boolean.TRUE);
		}
	}

	public boolean search(String word) {
		TrieNode p = searchNode(word);

		return p != null && p.isLeaf();
	}

	public boolean startsWith(String prefix) {
		TrieNode p = searchNode(prefix);

		return p != null;
	}

	public TrieNode searchNode(String s) {
		TrieNode p = null;
		if (s != null) {
			p = root;

			String wordLowerCase = s.toLowerCase();
			for (int i = 0; i < wordLowerCase.length(); i++) {
				char c = wordLowerCase.charAt(i);
				int index = c - 'a';
				if (p.getArr()[index] != null) {
					p = p.getArr()[index];
				} else {
					p = null;
					break;
				}
			}

			if (p == root)
				p = null;
		}
		return p;
	}
}