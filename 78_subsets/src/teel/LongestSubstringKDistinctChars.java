package teel;

import java.util.Arrays;

public class LongestSubstringKDistinctChars {
	
	 private int length_int(int start, char []charArray, int []c, int k) {
		int count = 0, i = 0;
		for (i = start; i < charArray.length && count <= k ; i++) {
			 if (c[charArray[i] - 'a'] == 0) {
				 count++;
			 }
			c[charArray[i] - 'a'] = i;
		}
		return i - start;
	 }
	 
	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
		 if (k == 0) return 0;
		 if (s.length() == 1) return 1;
		 char []charArray  = s.toCharArray();
		 int []c = new int [256];
		 Arrays.fill(c, -1);
		 int start = 0, max1 = 0, max = 0, i, count = 0;
		 while (start < s.length()) {
			 for (i = start; i < charArray.length && count <= k ; i++) {
				 int cv = charArray[i];
				 if (c[cv] == -1) {
					 if (count == k) {
						 break;
					 }
					 count++;
				 }
				c[cv] = i;
			 }
			 max1 = i - start;
			 max = Math.max(max, max1);
			 if (i == s.length()) {
				 break;
			 }
			 if (k == 1) {
				 start = c[charArray[start]] + 1;
			 } else {
				 start = c[charArray[start]];
			 }
			 //Reset counters for all characters seen before the new window start
			 for (int j = 0; j < c.length; j++) {
				if (c[j] > -1 && c[j] <= start) {
					c[j] = -1;
					count--;
				}
			}
			
		 }
		 return max;
	 }
}
