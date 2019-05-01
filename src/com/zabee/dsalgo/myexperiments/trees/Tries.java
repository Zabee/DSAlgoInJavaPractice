package com.zabee.dsalgo.myexperiments.trees;

public class Tries {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("amazon");
		trie.insert("amazing");
		trie.insert("ball");
		trie.insert("bat");
		trie.insert("cat");
		trie.insert("car");
		trie.insert("corridor");
	}
}

class Trie {
	TrieNode root = new TrieNode();

	public void insert(final String argWord) {
		TrieNode temp = root;
		char extractedChar;
		int index;
		for (int i = 0; i < argWord.length(); i++) {
			extractedChar = argWord.charAt(i);
			index = extractedChar - 'a';
			if (temp.children[index] == null) {
				TrieNode newNode = new TrieNode(extractedChar);
				temp.children[index] = newNode;
				temp = temp.children[index];
			} else {
				temp = temp.children[index];
			}
		}
		temp.endNode = true;
	}

	public boolean search(final String argWord) {
		TrieNode trieNode = searchInternal(argWord);
		return trieNode != null && trieNode.endNode;
	}

	public boolean prefix(final String argPrefix) {
		TrieNode trieNode = searchInternal(argPrefix);
		return trieNode != null;
	}

	public TrieNode searchInternal(final String argWord) {
		TrieNode temp = root;
		int index;
		char extractedChar;
		for (int i = 0; i < argWord.length(); i++) {
			extractedChar = argWord.charAt(i);
			index = extractedChar - 'a';
			if (temp.children[index] == null) {
				return null;
			}
			temp = temp.children[index];
		}
		if (temp == root) {
			return null;
		}
		return temp;
	}
}

class TrieNode {
	private char c;
	boolean endNode;
	TrieNode[] children;

	public TrieNode() {
		children = new TrieNode[26];
	}

	public TrieNode(char argChar) {
		c = argChar;
		endNode = false;
		children = new TrieNode[26];
	}
}
