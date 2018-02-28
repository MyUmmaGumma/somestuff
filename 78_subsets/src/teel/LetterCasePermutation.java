package teel;

import java.util.List;
import java.util.ArrayList;

public class LetterCasePermutation {
	public void letterCasePermutation_int(String s, List<String> res, int iter) {
		while (iter < s.length()) {
			char a = s.charAt(iter);
			StringBuilder sb = new StringBuilder(s);
			boolean changed = false;
			if (a >= 'a' && a <= 'z') {
				sb.setCharAt(iter, (char)('A' + (a - 'a')));
				changed = true;
			} else if (a >= 'A' && a <= 'Z') {
				sb.setCharAt(iter, (char)('a'+(a - 'A')));
				changed = true;
			}
			if (changed == true) {
			String s1 = sb.toString();
			res.add(s1);
			letterCasePermutation_int(s1, res, iter+1);
			}
			iter++;
		}
    }
	
	public List<String> letterCasePermutation(String S) {
		List<String> ls = new ArrayList<String>();
		ls.add(S);
		letterCasePermutation_int(S, ls, 0);
		return ls;
    }
	
	public static void main(String []args)
	{
		LetterCasePermutation lcp = new LetterCasePermutation();
		List<String> ls = lcp.letterCasePermutation("3124");
		for (String s : ls) {
			System.out.println(s);
		}
	}
}
