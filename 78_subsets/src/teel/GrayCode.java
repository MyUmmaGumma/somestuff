package teel;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	//From wikipedia
	/*
	 * Constructing an n-bit Gray code

The first few steps of the reflect-and-prefix method.

4-bit Gray code permutation
The binary-reflected Gray code list for n bits can be generated recursively from the list for n − 1 bits
 by reflecting the list (i.e. listing the entries in reverse order), prefixing the entries in the original
 list with a binary 0, prefixing the entries in the reflected list with a binary 1, 
 and then concatenating the original list with the reversed list.[
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> li = new ArrayList<>();
		if (n ==0) {
			li.add(0);
			return li;
		}
		List<String> s = new ArrayList<String>();
		for (int j= 1; j <= n; j++) {
			if (s.isEmpty()) {
				s.add("0");s.add("1");
				continue;
			}
			List<String> news = new ArrayList<String>();
			for (String s1 : s) {
				news.add("0" +new String(s1));
			}
			for (int i= s.size() -1; i>=0; i--) {
				news.add("1" + new String(s.get(i)) );
			}
			s = news;
		}
		for (String s1 : s) {
			li.add(Integer.parseInt(s1,2));
		}
		return li;
    }
	
	public static void main(String []args)
	{
		GrayCode gc = new GrayCode();
		List<Integer> li = gc.grayCode(5);
		for (Integer i : li) {
			System.out.println(i);
		}
	}
}
