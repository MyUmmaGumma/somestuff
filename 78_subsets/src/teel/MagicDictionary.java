package teel;

import java.util.Hashtable;

import teel.WordDictionary.TrieNode;

public class MagicDictionary {
	
	private Hashtable<Character, TrieNode> ht;
	
	public class TrieNode {
		Character c;
		Hashtable<Character, TrieNode> tries;
		boolean isWord;
	}
	
	 /** Initialize your data structure here. */
    public MagicDictionary() {
    	
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
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
        	insert(s);
        }
    }
    
    private boolean searchInt(String word, Hashtable<Character, TrieNode> ht, 
    			int pos, boolean ignore)
    {
    	if (pos == word.length() || ht == null) return false;
    	Character c = word.charAt(pos);
    	boolean contains = ht.containsKey(c); 
    	if (contains == false && ignore == false) {
    		//Already one change in the word
    		return false;
    	}
    	if (contains == true) {
    		TrieNode t = ht.get(c);
    		if (pos == word.length() - 1 && t.isWord) {
    			if (ignore == false) {
    				return true;
    			} else {
    				return false;
    			}
        	}
    		return searchInt(word, t.tries, pos + 1, ignore);
    	} else {
    		for(TrieNode t : ht.values()) {
    			return searchInt(word, t.tries, pos + 1, false);
    		}
    		return false;
    	}
    	
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	if (word.length() == 0) {
    		return false;
    	}
    	return searchInt(word, ht, 0, true);
         
    }
    
    public static void main(String []args)
    {
    	MagicDictionary md = new MagicDictionary();
    	String []newStrings  = {"hello", "leetcode"};
    	md.buildDict(newStrings);
    	System.out.println(md.search("hello"));
    	System.out.println(md.search("hhllo"));
    	System.out.println(md.search("hell"));
    	System.out.println(md.search("leetcoded"));
    }
}
