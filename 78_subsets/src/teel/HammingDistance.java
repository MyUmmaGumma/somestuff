package teel;

public class HammingDistance {
	int hammingDistance(int x, int y) {
		int i = 0, count = 0;
		while (i <= 31) {
			int d1 = (x & 1);
		    int d2 = (y & 1);
		    if (d1 != d2) {
		    		count++;
		    }
		    x = x >>1;
		    y = y >>1;
		    i++;
		}
		return count;
	}
	
	public static void main (String []args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(15, 31));
	}
}
