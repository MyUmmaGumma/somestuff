package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakSimple {
	enum Result {
		TRUE, FALSE, UNKNOWN;
	};
	
	HashMap<String, Result> hm = new HashMap<String, Result>();
	public boolean wordBreak_int(String first, int start, List<String> wordDict)
	{
		boolean res = false;
		if (hm.containsKey(first)) {
			return false;
		}
        for(int i = start; i <= first.length(); i++) {
        		String firsts = first.substring(0,i);
        		if (wordDict.contains(firsts)) {
        			if (first.substring(i).isEmpty()) {
        				return true;
        			}
        			 res = wordBreak_int(first.substring(i), 0, wordDict);
        			 if (res == true) {
        				 return true;
        			 }
        			 hm.put(first.substring(i), Result.FALSE);
        		}
        }
        return res;
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
		return wordBreak_int(s, 0, wordDict);
        
    }

	public static void main(String []args)
	{
		WordBreakSimple wbs = new WordBreakSimple();
		List<String> ls = new ArrayList<String>();
		/*ls.add("Lee");ls.add("Leet");ls.add("Cod");ls.add("Code");ls.add("Let");ls.add("Coder");
		System.out.println(wbs.wordBreak("LeetoCode", ls));
		System.out.println(wbs.wordBreak("LeetCode", ls));
		System.out.println(wbs.wordBreak("LeetCoder", ls));
		System.out.println(wbs.wordBreak("LeetCodes", ls));
		System.out.println(wbs.wordBreak("LetCodLet", ls));*/
		ls.add("a");ls.add("abc");ls.add("b");ls.add("cd");
		System.out.println(wbs.wordBreak("abcd", ls));
	}
}
