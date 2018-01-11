package teel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class NextGreaterNumber {
	class IntPos {
		public int val;
		public int pos;
		IntPos(int _val, int _pos) {
			val = _val;
			pos = _pos;
		}
	}
	
	IntPos
	find_min_greatest(ArrayList<IntPos> a, int b)
	{
		int ming = 99, pos = -1;
		for (IntPos item : a) {
			if (item.val > b && item.val < ming ) {
				ming = item.val;
				pos = item.pos;
			}
		}
		return new IntPos(ming, pos);
	}
	
	public int nextGreaterElement(int n) {
		if (n < 10) {
			return -1;
		}
		String s = Integer.toString(n);
		ArrayList<Character> chars = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			chars.add(c);
		}
		int min = -1, max = chars.get(chars.size()-1), maxpos = chars.size() -1, i = 0;
		boolean swap = false;
		
		ArrayList<IntPos> lhs = new ArrayList<IntPos>();
		lhs.add(new IntPos(max, maxpos));
		for ( i = chars.size()-2; i >=0 ; i--) {
			min = chars.get(i);
			// if min is less than any number find minimum greatest value
			for (IntPos ip : lhs) {
				if (min < ip.val) {
					IntPos fmg = find_min_greatest(lhs, min);
					Collections.swap(chars, i, fmg.pos);
					swap = true;
					break;
				} 
			}
			if (swap == true) {
				break;
			} else {
				//else add min to list
				lhs.add(new IntPos(min, i)); 
			}
		}
			
		//Sort remaining
		if (swap) {
			ArrayList<Character> newchars = new ArrayList<Character>(chars);
			for(int j = 0; j <= i; j++) {
				newchars.remove(0);
			}
			
			for(int j = i+1; j < chars.size(); ) {
				chars.remove(j);
			}
			Collections.sort(newchars);
			chars.addAll(newchars);
			int ret = 0;
			
			for (i = 0; i < chars.size(); i++) 
			{
				char c = chars.get(i);
				if (ret > Integer.MAX_VALUE/10) {
					ret = -1;
					break;
				} else {
					ret = 10*ret + (c- '0');
				}
			}
			return ret;
		} 
		return -1;
    }
	
	public static void main(String []args) 
	{
		NextGreaterNumber ngn = new NextGreaterNumber();
		System.out.println(ngn.nextGreaterElement(1999999999));
	}
}
