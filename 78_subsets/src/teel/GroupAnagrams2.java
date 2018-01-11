package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams2 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hmsls =
				new HashMap<String, List<String>>();
		
		for (int i = 0; i < strs.length; i++) {
			Character []cs =
				    strs[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
			
			Arrays.sort(cs);
			String key = "";
			for (Character c : cs) {
				key += c.charValue();
			}
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
		GroupAnagrams2 ga = new GroupAnagrams2();
		String []strs = {"eat", "tea", "tan", "ate", "nat", "bat", "tab", "tae","madam"};
		List<List<String>> lls = ga.groupAnagrams(strs);
		for (List<String> ls : lls) {
			for (String s : ls) {
				System.out.print(s + " ");
			}
			System.out.println();
			
		}
	}
}
