package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagramsInString {
	private int mismatch(int []a, int []b)
	{
		for (int i = 0; i < b.length; i++) {
			if (b[i] != a[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> li = new ArrayList<>();
        if (s.length() < p.length()) return li;
        int c[] = new int[26];
        int empty[] = new int [26];
        for (char d : p.toCharArray()) {
			c[d - 'a']++;
		}
        char []sarr = s.toCharArray();
        	for (int i = 0; i + p.length()<= sarr.length; i++) {
        		int []ccopy = Arrays.copyOf(c, 26);
        		
			for (int j = 0; j <  p.length(); j++) {
				ccopy[sarr[i + j] - 'a']--;
			}
			if (mismatch(ccopy, empty) == -1)
			{
				li.add(i);
			}
		}
        	return li;
    }
}
