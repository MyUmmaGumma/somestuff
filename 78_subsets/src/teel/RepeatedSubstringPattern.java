package teel;

import java.util.regex.Pattern;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		int slen = s.length();
		for (int i =1; i <= slen/2; i++) {
			if (slen % (i) != 0) continue;
			String sub = s.substring(0, i);
			String []toks = s.split(sub, -1);
			int len = slen/sub.length();
			if (toks.length - 1 == len) {
				return true;
			}
		}
		return false;
    }
}
