package teel;

import java.util.ArrayList;
import java.util.Hashtable;

import teel.Trie.TrieNode;

public class WordDictionary {
	private static final int ALPHABET = 26;
	private Hashtable<Character, TrieNode> ht;
	
	public class TrieNode {
		Character c;
		Hashtable<Character, TrieNode> tries;
		boolean isWord;
	}
	
	public WordDictionary() {
    	/** Initialize your data structure here. */
    	ht = new Hashtable<Character, TrieNode>();    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        insert(word);
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
    	return search(word, ht);
    }
    
  
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean search(String prefix, Hashtable<Character, TrieNode> localht) {
    	if (prefix.length() == 0) {
    		return false;
    	}
    	if (localht == null) {
    		return false;
    	}
		Character c = prefix.charAt(0);
		if (c != '.') {
			if (localht.containsKey(c)) {
				TrieNode t = localht.get(c);
				if (prefix.length() == 1 && t.isWord == true) {
					return true;
				}
				
				return search(prefix.substring(1), t.tries);
			} else {
				return false;
			}
		} else {
			// If the character is a . do a DFS ignoring character matches, 
			// declare not found if no path from current TrieNode has a success ever
			for (TrieNode t : localht.values()) {
				if (prefix.length() == 1 && t.isWord == true) {
					return true;
				}
				if (search(prefix.substring(1), t.tries) == true) {
					return true;
				}
			}
			return false;
		}
    }
    
    public static void main(String []args)
    {
    	WordDictionary test = new WordDictionary();
    	test.insert("at");
    	test.insert("and");
    	test.addWord("an");
    	test.addWord("add");
    	
    	System.out.println(test.search("bat"));
    	System.out.println(test.search(".at"));
    	System.out.println(test.search(".at"));
    	System.out.println(test.search("an."));	
    	System.out.println(test.search("a.d."));
    	System.out.println(test.search("b."));
    	System.out.println(test.search("a.d"));
    	
    }
}
