package teel;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description

public class LongestSubstringWoRepeatingCharacters {
	//HashSet<Character> hs = new HashSet<Character>();
	HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
	public int lengthOfLongestSubstring(String s) {
		int i = 0, max = 0, start = 0, prevmax=0;
		hs.clear();
        for ( i = 0; i < s.length(); i++) {
        	Character c = s.charAt(i);
        	if (hs.containsKey(c)) {
        		if (hs.get(c) >= start )
        			start = hs.get(c) + 1;
        	}
        	hs.put(c, i);
        	max = Math.max(max, i - start+1);
        	
        }
        /*if (max == 0) {
        	max++;
        }
        max = ((i -1) - start);
        */
        return max;
    }
	
	public static void main(String []args) {
		LongestSubstringWoRepeatingCharacters lswrc = new LongestSubstringWoRepeatingCharacters();
		System.out.println(lswrc.lengthOfLongestSubstring("bbtablud"));
		System.out.println(lswrc.lengthOfLongestSubstring("abba"));
		System.out.println(lswrc.lengthOfLongestSubstring("aaabc"));
		System.out.println(lswrc.lengthOfLongestSubstring("ababc"));
		System.out.println(lswrc.lengthOfLongestSubstring("abdabc"));
		System.out.println(lswrc.lengthOfLongestSubstring("au"));
		System.out.println(lswrc.lengthOfLongestSubstring("ohomm"));
	}
}
