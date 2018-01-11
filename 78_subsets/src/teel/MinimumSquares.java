package teel;

import java.util.Hashtable;

public class MinimumSquares {
	Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
	
	
	public int numSquares(int n) {
		if (n == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		if (ht.containsKey(n)) {
			return (Integer)ht.get(n);
		} else {
			int c = 0, m = n;
			int i = (int)Math.abs(Math.sqrt(n));
			if (i*i == n) {
				ht.put(n, i);
				return 1;
			}
			
			int a = n;
			for (; i >= 1; i--) {
				
				c = 1;

				a = n - (i * i);
				if (a != 0) {
					c += numSquares(a);
				}
				if (c < min) {
					min = c;
					a = 0;
				}
			}
			System.out.println("For " + m + " = " + min);
			ht.put(m, min);
		}
		return min;
    }
	
	public static void main(String []args)
	{
		int a = 26;
		MinimumSquares ms = new MinimumSquares();
		System.out.println(a + " = "+ ms.numSquares(a));
	}
}
