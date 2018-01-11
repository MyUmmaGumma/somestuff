package teel;

import java.util.ArrayList;
import java.util.Hashtable;

import teel.Trie.TrieNode;

public class Trie {
	
	
	
	private static final int ALPHABET = 26;
	private Hashtable<Character, TrieNode> ht;
	
	public class TrieNode {
		Character c;
		Hashtable<Character, TrieNode> tries;
		boolean isWord;
	}
	
	/** Initialize your data structure here. */
    public Trie() {
    	ht = new Hashtable<Character, TrieNode>();
    }
    
    private TrieNode createFreshNode(String word, int iter)
    {
    	TrieNode prev = null;
    	TrieNode ret = prev;
    	for(int i = iter; i < word.length(); i++) {
    		TrieNode newNode = new TrieNode();
    		newNode.c = word.charAt(i);
    		newNode.isWord = false;
    		if (prev != null) {
    			prev.tries = new Hashtable<Character, TrieNode>();
        		prev.tries.put(word.charAt(i), newNode);
    		} else {
    			ret = newNode;
    		}
    		prev = newNode;
    	}
    	
    	prev.isWord = true;
    	return ret;
    }
    
    private void insertToExistingNode(TrieNode root, String word, int iter)
    {
    	if (iter == word.length()) {
    		root.isWord = true;
    		return;
    	}
    	if (root == null) {
    		return;
    	}
    	if (root.tries == null && iter == word.length()) {
    		root.isWord = true;
    		return;
    	} 
    	if (root.tries != null && root.tries.containsKey(word.charAt(iter))) {
    		insertToExistingNode(root.tries.get(word.charAt(iter)),
    				word, iter+1);
    	} else {
    		TrieNode t = createFreshNode(word, iter);
    		if (root.tries == null) {
    			root.tries = new Hashtable<Character, TrieNode>();
    		}
    		root.tries.put(word.charAt(iter), t);
        	
    		
    	}
    	
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if (ht.containsKey(word.charAt(0))) {
			TrieNode root = ht.get(word.charAt(0));
			insertToExistingNode(root, word, 1);
		} else {
			TrieNode tn = createFreshNode(word, 0);
			ht.put(word.charAt(0), tn);
			return;
		}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if (word.length() == 0) {
    		return false;
    	}
    	TrieNode root = ht.get(word.charAt(0));
    	if (root == null) {
    		return false;
    	}
    	for (int i = 1; i < word.length(); i++) {
    		if (root.tries != null && root.tries.containsKey(word.charAt(i))) {
    			root = root.tries.get(word.charAt(i));
    		} else {
    			return false;
    		}
    	}
    	if (root.isWord == false) {
    		return false;
    	}
    	return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if (prefix.length() == 0) {
    		return false;
    	}
    	TrieNode root = ht.get(prefix.charAt(0));
    	if (root == null) {
    		return false;
    	}
    	for (int i = 1; i < prefix.length(); i++) {
    		if (root.tries != null && root.tries.containsKey(prefix.charAt(i))) {
    			root = root.tries.get(prefix.charAt(i));
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String []args)
    {
    	Trie test = new Trie();
    	test.insert("test");
    	test.insert("tea");
    	System.out.println("Searching for test: " + test.search("test"));
    	System.out.println("Searching for tea: " + test.search("tea"));
    	System.out.println("Searching for teapot: " + test.search("teapot"));
    	test.insert("temecula");
    	test.insert("BBQ");
    	test.insert("Barbados");
    	test.insert("Barbie");
    	System.out.println("Searching for Barbados: " + test.search("Barbados"));
    	System.out.println("Searching for Barby: " + test.search("Barby"));
    	System.out.println("Searching for Barb: " + test.search("Barb"));
    	System.out.println("Searching for starts with Barby: " + test.startsWith("Barby"));
    	System.out.println("Searching for starts with Barb: " + test.startsWith("Barb"));
    	System.out.println("Searching for Barbie: " + test.search("Barbie"));
    	
    	
    	test.insert("ab");
    	System.out.println("Searching for ab: " + test.search("ab"));
    	test.insert("abc");
    	System.out.println("Searching for abc: " + test.search("abc"));
    	
    }
}
