package teel;

import java.util.Arrays;

public class UglyNumber2 {
	public int nthUglyNumber(int n) {

		int ugly[] = new int [n+1];
		Arrays.fill(ugly, n);
		int two_iter = 2, three_iter = 3, five_iter = 5, num = 0;
		int i2 = 0,i3 = 0,i5 = 0;
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			num = Math.min(two_iter, Math.min(three_iter, five_iter));
			ugly[i] = num;
			
			if (num == two_iter) {
				i2++;
				two_iter = ugly[i2] *2; 
				
			} 
			if (num == three_iter) {
				i3++;
				three_iter = ugly[i3] *3;
				
			} 
			if (num == five_iter){
				i5++;
				five_iter = ugly[i5] * 5;
			}
		}
		return num;
    }
	
	public static void main(String []args)
	{
		UglyNumber2 ug2 = new UglyNumber2();
		System.out.println(ug2.nthUglyNumber(11));
	}
}
