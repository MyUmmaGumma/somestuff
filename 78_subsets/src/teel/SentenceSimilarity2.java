package teel;

import java.util.Arrays;
import java.util.HashMap;

public class SentenceSimilarity2 {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length ==0 && words2.length == 0) return true;
		if (words1.length != words2.length) return false;
		
		 
		 if (pairs.length == 0) {
			 Arrays.sort(words2);
			 for (String words: words1) {
				 if (Arrays.binarySearch(words2, words) == -1) {
					 return false;
				 }
			 }
			 return true;
		 }
		 
		class UF {
			int []arr = null;
			
			public UF(int n) 
			{
				arr = new int[n];
				Arrays.fill(arr, -1);
			}
			
			public void Union(int i, int j)
			{
				int root1 = FindRoot(i);
				int root2 = FindRoot(j);
				if (root1 != root2) {
					arr[root1] = root2;
				}
			}
			
			public int FindRoot(int pos)
			{
				if (arr[pos] == -1) 
					return pos;
				while (arr[pos] != -1) {
					pos = arr[pos];
				}
				return pos;
			}
		}
		HashMap<String, Integer> hm = new HashMap<>();
		int i = 0;
		UF uf = new UF(pairs.length*2);
		for (String [] pair : pairs) {
			for (String s : pair) {
				if (!hm.containsKey(s)) {
					hm.put(s, i++);
				}
			}
			uf.Union(hm.get(pair[0]), hm.get(pair[1]));
		}
		
		
		for (i = 0; i < words1.length; i++) {
			String word1 = words1[i];
			String word2 = words2[i];
			
			if (word1.contentEquals(word2)) {
				continue;
			}
			if (hm.containsKey(word1) == false || hm.containsKey(word2) == false) {
				return false;
			}
			int pos1 = uf.FindRoot(hm.get(word1));
			int pos2 = uf.FindRoot(hm.get(word2));
			if (pos1 == pos2) {
				continue;
			}
			return false;
		}
		return true;
    }
	
	 public static void main(String []args)
	 {
		 String [][]pairs = {{"great", "fine"}, {"drama","acting"}, {"skills","talent"}};
		 String []s1 = {"fine", "drama", "talent"};
		 String []s2 = {"great", "acting", "skills"};
		 String []s3 = {"yesterday", "james","have", "an","extraordinary","meal"};
		 String []s4 = {"yesterday", "james","take", "one","good","dinner"};
		 String [][]pairs2 =  {{"great","good"},{"extraordinary","good"},{"well","good"},{"wonderful","good"},{"excellent","good"},{"fine","good"},
				 {"nice","good"},{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},{"single","one"},
				 {"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},{"vehicle","car"},
				 {"entertain","have"},{"drink","have"},{"eat","have"},{"take","have"},{"fruits","meal"},{"brunch","meal"},
				 {"breakfast","meal"},{"food","meal"},{"dinner","meal"},{"super","meal"},{"lunch","meal"},{"possess","own"},
				 {"keep","own"},{"have","own"},{"extremely","very"},{"actually","very"},{"really","very"},{"super","very"}};
		 SentenceSimilarity2 ss = new SentenceSimilarity2();
		 System.out.println(ss.areSentencesSimilarTwo(s3, s4, pairs2));
	 }
}
