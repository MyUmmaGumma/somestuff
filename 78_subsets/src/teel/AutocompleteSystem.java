package teel;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem {
	class TrieNode
	{
		TrieNode []c;
		boolean isWord;
		int occurrences;
		TrieNode() {
			c = new TrieNode [28];
			isWord = false; occurrences = 0;
		}
	}
	
	TrieNode root;
	
	class StringCount {
		String sentence;
		int count;
		StringCount(int _count, String _sent) {
			sentence = _sent; count = _count;
		}
	}
	PriorityQueue<StringCount> pq;
	
	private void addToTrie(Character c)
	{
		
	}
	
/*	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		
		pq = new PriorityQueue<StringCount>( new Comparator<StringCount>() {
			@Override
			public int compare(StringCount arg0, StringCount arg1) {
				return Integer.compare(arg1.count, arg0.count);
			}
		});
		for (int i = 0; i < times.length; i++) {
			pq.add(new StringCount(times[i], sentences[i]));
		}
		for (String s : sentences) {
			char []schars = s.toCharArray();
			for (int i = 0; i < schars.length; i++) {
				addToTrie(schars[i]);
			}
		}
    }*/
    
    public List<String> input(char c) {
        return null;
    }
}
