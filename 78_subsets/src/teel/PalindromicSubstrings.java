package teel;

import java.util.Arrays;

public class PalindromicSubstrings {
	private int expandAround(char []newch, int i)
	{
		int l = i, r = i, count = 0;
		while (l-1 >= 0 && r+1 < newch.length) {
			if (newch[l-1] == newch[r+1]) {
				if (newch[l-1] != '.')
					count++;
			} else {
				break;
			}
			l--; r++;
		}
		return count;
	}
	
	public int countSubstrings(String s) {
		char []ch = s.toCharArray();
		char []newch = new char [ch.length *2 -1];
		Arrays.fill(newch, '.');
		for (int i = 0; i < ch.length; i++) {
			newch[i*2] = ch[i];
		}
		int count = s.length();
		for (int i = 0; i < newch.length; i++) {
			count += expandAround(newch, i);
		}
		return count;
    }
}
