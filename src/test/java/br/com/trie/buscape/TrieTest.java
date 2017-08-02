package br.com.trie.buscape;

import java.util.Collection;

import org.junit.Test;

import junit.framework.TestCase;

public class TrieTest extends TestCase {

	private Trie trie;

	@Override
	protected void setUp() throws Exception {
		trie = new Trie('a', 26);

		trie.insert("by");
		trie.insert("sea");
		trie.insert("sell");
		trie.insert("sells");
		trie.insert("shells");
		trie.insert("the");
		trie.insert("th");
		trie.insert("see");
		trie.insert("se");
		trie.insert("sh");

		super.setUp();
	}

	@Test
	public void test() {
		assertTrue(trie.search("by"));
		assertTrue(trie.search("sea"));
		assertTrue(trie.search("sell"));
		assertTrue(trie.search("sells"));
		assertTrue(trie.search("shells"));
		assertTrue(trie.search("the"));
		assertTrue(trie.search("sh"));
		
		assertFalse(trie.search("b"));
		assertFalse(trie.search("s"));
		assertFalse(trie.search("sel"));
		assertFalse(trie.search("t"));
		assertFalse(trie.search("she"));
		
		assertTrue(trie.startsWith("b"));
		assertTrue(trie.startsWith("s"));
		assertTrue(trie.startsWith("sel"));
		assertTrue(trie.startsWith("t"));
		assertTrue(trie.startsWith("she"));
	}
}
