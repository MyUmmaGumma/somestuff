package teel;

import java.util.Arrays;

public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 for (int i = digits.length - 1; i >= 0; i--) {
			 if (digits[i] != 9) {
				 digits[i]++;
				 return digits;
			 }
			 digits[i] = 0;
		 }
		 int []newdigits = new int[digits.length + 1];
		 Arrays.fill(newdigits, 0);
		 newdigits[0] = 1;
		 return newdigits;
	 }
	 
	 public static void main(String []args)
	 {
		 PlusOne po = new PlusOne();
		 int []d1 = {1,9,9};
		 int []d2 = {1,8,9};
		 int []d3 = {9,9,9,9};
		 int []p1 = po.plusOne(d1);
		 int []p2 = po.plusOne(d2);
		 int []p3 = po.plusOne(d3);
		 System.out.println(Arrays.toString(p1));
		 System.out.println(Arrays.toString(p2));
		 System.out.println(Arrays.toString(p3));
	 }
}
