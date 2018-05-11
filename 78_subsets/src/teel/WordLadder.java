package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {
	  
	/*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.add(beginWord);
		visited.add(beginWord);
		
		int level = 1;
		
		while (!queue.isEmpty()) {
			String candidate = queue.remove(0);
			//Change one char at a time and if the word is in the dictionary add to queue
			
			for (int i = 0; i < candidate.length();i++) {
				char []arr = candidate.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					arr[i] = c;
					String s =  new String(arr);
					
					if (wordList.contains(s) && !visited.contains(s)) {
						if (s.contentEquals(endWord)) {
							return level;
						}
						queue.add(s);
						visited.add(s);
					}
				}
			}
			level++;
		}
		return 0;
    }*/
	public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
		HashSet<String> curr = new HashSet<>();
		curr.add(beginWord);
		wordDict.add(endWord);
		int level = 1;
		while (!curr.contains(endWord)) {
			HashSet<String> reachable = new HashSet<>();
			for (String each : curr) {
				
				for (int i = 0; i < each.length(); i++) {
					char []c = each.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						c[i] = ch;
						String target = String.valueOf(c);
						if (wordDict.contains(target)) {
							reachable.add(target);
							wordDict.remove(target);
						}
					}
				}
			}
			level++;
			if (reachable.size() == 0) return 0;
			curr = reachable;
		}
		return level;
	}
}
