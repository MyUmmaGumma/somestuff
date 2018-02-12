package teel;

public class CountingBits2 {
	//Example:
	//For num = 5 you should return [0,1,1,2,1,2].
	 public int[] countBits(int num) {
		 int []ret = new int [num];
		 ret[0] = 0;
		 if (num == 0) {
			 return ret;
		 }
		 ret[1] = 1;
		 if (num == 1) {
			 return ret;
		 }
		 for (int i = 2; i < num; i++) {
			 ret[i] = ret[i/2];
			 if (i%2 == 1) {
				 ret[i]++;
			 }
		 }
		 return ret;
	 }
	 
	 public static void main(String []args)
	 {
		 CountingBits2 cb2 = new CountingBits2();
		 int []arr = cb2.countBits(16);
		 for (int i : arr) {
			 System.out.println(i);
		 }
	 }
}
