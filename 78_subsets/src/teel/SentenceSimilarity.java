package teel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {
	/* public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		
		 if (words1.length ==0 && words2.length == 0) return true;
		 if (words1.length != words2.length) return false;
		 
		 Map<String, Set<String>> m = new HashMap<>();
		 Map<String, String> m1 = new HashMap<>();
		 
		 Arrays.sort(words2);
		 if (pairs.length == 0) {
			 for (String words: words1) {
				 if (Arrays.binarySearch(words2, words) == -1) {
					 return false;
				 }
			 }
			 return true;
		 }
		 
		 for (String []s : pairs) {
			 String s1 = s[0];
			 String s2 = s[1];
			 if (m.containsKey(s2)) {
				 Set<String> hs = m.get(s2);
				 hs.add(s1);
			 } else {
				 Set<String> hs = new HashSet<String>();
				 hs.add(s1);
				 m.put(s2, hs);
			 }
		 }
		 
		 m.forEach((k,v) -> {
			 for (String s : v) {
				 m1.put(s, k);
			 }
		 });
		 
		 for (String w1 : words1) {
			 if (!m.isEmpty() && !m.containsKey(w1)) {
				 if (!m1.isEmpty() && !m1.containsKey(w1)) {
					 return false;
				 }
			 }
			 Set<String> vals = (!m.isEmpty()) ? m.get(w1): null;
			 if (vals != null) {
				 for (String val : vals) {
					 if (Arrays.binarySearch(words2, val) != -1 ||
						 Arrays.binarySearch(words2, w1) == -1) {
						 continue;
					 }
					 return false;
				 }
			 } else {
				 if (m1.isEmpty()) {
					 return false;
				 }
				 String s = m1.get(w1);
				 if (Arrays.binarySearch(words2, s) == -1) {
					 return false;
				 }
			 }
		 }
	     return true; 
	 } */
	
	public boolean areSentencesSimilar(
            String[] words1, String[] words2, String[][] pairs) {
		Set<String> s = new HashSet<String>();
		for (String []p : pairs) {
			s.add(p[0] + "#" + p[1]);
			s.add(p[1] + "#" + p[0]);
		}
		
		int  i =0;
		for (String word : words1) {
			String word2 = words2[i];
			if (!word.contentEquals(words2[i]) &&
					!s.contains(word+"#"+word2) &&
					!s.contains(word2+"#"+word)) {
				return false;
			}
			i++;
		}
		return true;
	}
	 
	 public static void main(String []args)
	 {
		 String [][]pairs = {{"great", "fine"}, {"drama","acting"}, {"skills","talent"}};
		 String []s1 = {"fine", "drama", "talent"};
		 String []s2 = {"great", "acting", "skills"};
		 String []s3 = {"an","extraordinary","meal"};
		 String []s4 = {"a","good","dinner"};
		 String [][]pairs2 =  {{"great","good"},{"extraordinary","good"},{"well","good"},{"wonderful","good"},{"excellent","good"},{"fine","good"},
				 {"nice","good"},{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},{"single","one"},
				 {"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},{"vehicle","car"},
				 {"entertain","have"},{"drink","have"},{"eat","have"},{"take","have"},{"fruits","meal"},{"brunch","meal"},
				 {"breakfast","meal"},{"food","meal"},{"dinner","meal"},{"super","meal"},{"lunch","meal"},{"possess","own"},
				 {"keep","own"},{"have","own"},{"extremely","very"},{"actually","very"},{"really","very"},{"super","very"}};
		 SentenceSimilarity ss = new SentenceSimilarity();
		 System.out.println(ss.areSentencesSimilar(s1, s2, pairs));
		 //System.out.println(ss.areSentencesSimilar(s3, s4, pairs2));
		 String [][]p = {};
		 String []s5 = {"great"};
		 String []s6 = {"great"};
		//System.out.println(ss.areSentencesSimilar(s5, s6, p));
	 }
}
