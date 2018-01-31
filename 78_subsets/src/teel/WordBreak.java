package teel;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> ls = new ArrayList<String>();
		backtrack(ls, wordDict, new StringBuilder(), s, 0);
		return ls;
    }
	
	private void backtrack(List<String> ls, List<String> wordDict, StringBuilder temp, 
			String remaining, int start)
	{
		if (remaining.length() == 0) {
			ls.add(temp.toString());
			return;
		}
		for (int i = start; i <= remaining.length(); i++) {
			String subs = remaining.substring(0, i);
			if (wordDict.contains(subs)) {
				int starttemp = temp.length();
				temp.append(subs);
				if (i != remaining.length())
					temp.append(' ');
				int end = temp.length();
				backtrack(ls, wordDict, temp, remaining.substring(i), start+1);
				temp.delete(starttemp, end);
			}
			//backtrack(ls, wordDict, temp, remaining, start+1);
		}
	}
	
	public static void main(String []args)
	{
		WordBreak wb = new WordBreak();
		List<String> ls = new ArrayList<String>();
		/* ls.add("cat");ls.add("cats");ls.add("and");ls.add("dog");ls.add("sand");ls.add("dogs");*/
		//List<String> res = wb.wordBreak("catsanddog", ls);
		
		ls.add("b");ls.add("a");
		List<String> res = wb.wordBreak("ab", ls);
		for (String r : res) {
			System.out.println(r);
		}
	}
}
