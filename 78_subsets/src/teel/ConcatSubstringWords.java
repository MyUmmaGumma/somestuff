package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ConcatSubstringWords {
	
	HashMap<String, Integer> hs = new HashMap<String, Integer>();
	
	private boolean condition(String next, HashMap<String, Integer> seen)
	{
		if (hs.containsKey(next)) {
			int occurences = hs.get(next);
			if (seen.containsKey(next)) {
				int allowed = seen.get(next);
				if (occurences > allowed) {
					allowed++;
					seen.put(next, allowed);
					return true;
				}
			} else {
				seen.put(next, 1);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<Integer>();
		for (String word : words) {
			if (!hs.containsKey(word))
				hs.put(word, 1);
			else {
				Integer i = hs.get(word);
				i++;
				hs.put(word, i);
			}
		}
		
		int j = words[0].length();
		for(int i = 0; i < s.length(); i++) {
			HashMap<String, Integer> seen = new HashMap<String, Integer>();
			int count = 0;
			for (int k = i; k < s.length(); k += j) {
				if (k + j >= s.length()) break;
				String next = s.substring(k, k+j);
				
				if (!condition(next, seen)) {
					break;
				} else {
					count++;
				}
				
				if (count == words.length) {
					ret.add(i);
					break;
				}
			}
		}
		return ret;
    }
	
	public static void main(String []args)
	{
		String []words = {"foo", "bar"};
		String s = "barfoothefoobarman";
		ConcatSubstringWords csw = new ConcatSubstringWords();
		List<Integer> ls = csw.findSubstring(s, words);
		System.out.print(s + ":");
		for (Integer i: ls) {
			System.out.print(" " + i);
		}
		System.out.println("");
		
		String s1 = "wordgoodgoodbestword";
		String []words1 = {"word","good","best","good"};
		ConcatSubstringWords csw1 = new ConcatSubstringWords();
		System.out.print(s + ":");
		List<Integer> ls1 = csw1.findSubstring(s1, words1);
		for (Integer i: ls1) {
			System.out.print(" " + i);
		}
		System.out.println("");
	}
}
