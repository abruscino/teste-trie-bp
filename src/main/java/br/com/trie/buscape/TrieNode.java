package br.com.trie.buscape;
public class TrieNode {
	private TrieNode[] arr;
	private boolean leaf;

	public TrieNode(int alphabetSize) {
		this.arr = new TrieNode[alphabetSize];
	}

	public TrieNode[] getArr() {
		return arr;
	}

	public void setArr(TrieNode[] arr) {
		this.arr = arr;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
}