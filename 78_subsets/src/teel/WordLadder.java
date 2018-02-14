package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {
	  
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.add(beginWord);
		visited.add(beginWord);
		
		int level = 0;
		
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
							return level+1;
						}
						queue.add(s);
						visited.add(s);
					}
				}
			}
			level++;
		}
		return 0;
    }
	  
	  public static void main(String []args)
	  {
		  WordLadder wl = new WordLadder();
		  List<String> ls = new ArrayList<>();
		  ls.add("cat");ls.add("rat");
		  ls.add("car");ls.add("tat");

		
		  System.out.println(wl.ladderLength("cat", "rot", ls));
	  }
}
