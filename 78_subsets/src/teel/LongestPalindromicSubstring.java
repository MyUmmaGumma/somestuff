package teel;

import java.util.Arrays;

public class LongestPalindromicSubstring {
	private int[] expandAround(char []newch, int i)
	{
		int l = i, r = i;
		int len = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(newch[i]);
		while (l-1 >= 0 && r+1 < newch.length) {
			if (newch[l-1] == newch[r+1]) {
				len += 2;
			} else {
				break;
			}
			l--; r++;
		}
		return new int[] {l,r, len+1};
		
	}
	
	public String longestPalindrome(String s) {
		char []ch = s.toCharArray();
		char []newch = new char [ch.length *2 -1];
		Arrays.fill(newch, '.');
		for (int i = 0; i < ch.length; i++) {
			newch[i*2] = ch[i];
		}
		int max = 0;
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < newch.length; i++) {
			int []lr = expandAround(newch, i);
			
			int start =  (lr[0] < 0) ? 0 : lr[0];
			int end =  (lr[1] >= newch.length) ? newch.length : lr[1];
			StringBuilder sb = new StringBuilder();
			for(int j = start; j <= end; j++) {
				if (newch[j] != '.') 
					sb.append(newch[j]);
			}
			if (sb.length() > ret.length()) {
				ret.replace(0, sb.length(), sb.toString());
			}
		
		}
		return ret.toString();
    }
}
