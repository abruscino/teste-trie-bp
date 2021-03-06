package br.com.trie.buscape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class Trie {
	private TrieNode root;
	private final char initialCharacter;

	public Trie(char initialCharacter, int alphabetSize) {
		root = new TrieNode(alphabetSize);
		this.initialCharacter = initialCharacter;
	}

	public void insert(String word) {
		if (word != null) {
			TrieNode p = root;
			String wordLowerCase = word.toLowerCase();
			for (int i = 0; i < wordLowerCase.length(); i++) {
				char c = wordLowerCase.charAt(i);
				int index = c - initialCharacter;
				if (p.getArr()[index] == null) {
					TrieNode temp = new TrieNode(p.getArr().length);
					p.getArr()[index] = temp;
					p = temp;
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

	public Collection<String> keysWithPrefix(String prefix) {
		Collection<String> c = new ArrayList<String>();
		collect(searchNode(prefix), prefix, c);
		return c;
	}

	private void collect(TrieNode node, String prefix, Collection<String> c) {
		if (node == null)
			return;

		if (node.isLeaf())
			c.add(prefix);

		for (char i = 0; i < node.getArr().length; i++) {
			String next = prefix + (char)(initialCharacter + i);
			collect(searchNode(next), next, c);
		}
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