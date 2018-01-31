package teel;

import java.util.Arrays;

public class AssignCookie {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, count = 0;
		for (int j = 0; i < g.length && j < s.length;) {
			if (g[i] > s[j]) {
				j++;
			} else {
				i++;
				j++;
				count++;
			}
		}
		return count;
    }
	
	public static void main(String []args)
	{
		AssignCookie ac = new AssignCookie();
		int []g = {1,2,3};
		int []s = {1,1};
		System.out.println(ac.findContentChildren(g, s));
		int []g1 = {1,2};
		int []s1 = {1,2,3};
		System.out.println(ac.findContentChildren(g1, s1));
		int []g2 = {10,9,8,7};
		int []s2 = {5,6,7,8};
		System.out.println(ac.findContentChildren(g2, s2));
		
	}
}
