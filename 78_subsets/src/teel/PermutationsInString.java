package teel;

import java.util.Arrays;

public class PermutationsInString {
	private int mismatch(int []a, int []b)
	{
		for (int i = 0; i < b.length; i++) {
			if (b[i] != a[i]) {
				return i;
			}
		}
		return -1;
	}

	 public boolean checkInclusion(String s1, String s2) {
		 int []s1arr = new int[26];
		 for (char c : s1.toCharArray()) {
			 s1arr[c - 'a']++;
		 }
		char []sarr = s2.toCharArray();
		int empty[] = new int [26];
     	for (int i = 0; i + s1.length()<= sarr.length; i++) {
     		int []ccopy = Arrays.copyOf(s1arr, 26);
    		
			for (int j = 0; j <  s1.length(); j++) {
				ccopy[sarr[i + j] - 'a']--;
			}
			if (mismatch(ccopy, empty) == -1)
			{
				return true;
			}
     	}
     	return false;
	 }
}
