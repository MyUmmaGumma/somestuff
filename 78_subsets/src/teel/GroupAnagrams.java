package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {
	class Stringizer
	{
		HashMap<Character, Integer> hmsi;
		Stringizer(String s)
		{
			hmsi = new HashMap<Character, Integer> ();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (hmsi.containsKey(c)) {
					Integer value = hmsi.get(c);
					hmsi.put(c, value+1);
				} else {
					hmsi.put(c, 1);
				}
			}
		}
		
		public String toString()
		{
			String s = "";
			Set<Character> sc = hmsi.keySet();
			
			Character []cs = new Character[sc.size()];
			int i = 0;
			for(Character c : sc) {
				cs[i++] = c;
			}
			Arrays.sort(cs);
			for (Character c : cs) {
				s += c;
				s += hmsi.get(c);
			}
			return s;
			
		}
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hmsls =
				new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++)
		{
			Stringizer s = new Stringizer(strs[i]);
			String key = s.toString();
			if (hmsls.containsKey(key)) {
				List<String> ls = hmsls.get(key);
				ls.add(strs[i]);
				hmsls.put(key, ls);
			} else {
				List<String> ls = new ArrayList<String>();
				ls.add(strs[i]);
				hmsls.put(key, ls);
			}
		}
		List<List<String>> lls = new ArrayList<List<String>>();
		for (String s : hmsls.keySet()) {
			List<String> ls = hmsls.get(s);
			lls.add(ls);
		}
		return lls;
    }
	
	public static void main(String []args)
	{
		GroupAnagrams ga = new GroupAnagrams();
		String []strs = {"eat", "tea", "tan", "ate", "nat", "bat", "tab", "tae"};
		List<List<String>> lls = ga.groupAnagrams(strs);
		for (List<String> ls : lls) {
			for (String s : ls) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
