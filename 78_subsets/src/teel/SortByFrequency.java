package teel;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortByFrequency {
	class AnnotatedChar {
		Character c; int count;
		public AnnotatedChar(Character c1)
		{
			c = c1; count = 1;
		}
	}
	public String frequencySort(String s) {
		AnnotatedChar []ac = new AnnotatedChar[256];
		char []schars = s.toCharArray();
		for (int i = 0; i < schars.length; i++) {
			AnnotatedChar ac1 = ac[schars[i]];
			if (ac1 == null) {
				ac[schars[i]] = new AnnotatedChar(schars[i]);
			} else {
				ac1.count++;
			}
		}
		
		PriorityQueue<AnnotatedChar> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
		
		for (AnnotatedChar ac1 : ac) {
			if (ac1 != null) {
				pq.add(ac1);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			AnnotatedChar ac1 = pq.poll();
			for (int i = 0; i < ac1.count; i++) 
				sb.append(ac1.c);
		}
		return sb.toString();
	}
}
