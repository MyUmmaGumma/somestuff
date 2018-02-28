package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DnaRepeatedSubsequences {
	private boolean isSubstring(String s, String target)
	{
		return s.contains(target);
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> ss = new HashSet<String>();
		Set<String> ls = new HashSet<String>();
		for (int i = 0 ; i < s.length()-9; i++) {
			String subs = s.substring(i, i+10);
			if (!ss.add(subs)) {
				ls.add(subs);
			}
		}
		return new ArrayList(ls);
    }
	
	public static void main(String []args)
	{
		DnaRepeatedSubsequences dna = new DnaRepeatedSubsequences();
		//String s =  "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s =  "AAAAAAAAAAAA";
		List<String> res = dna.findRepeatedDnaSequences(s);
		for (String s1 : res) {
			System.out.println(s1);
		}
	}
}
