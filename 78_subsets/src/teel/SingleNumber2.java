package teel;

public class SingleNumber2 {
	public int singleNumber(int[] nums) {
		int sum = 0;
		int ans = 0;
		
		for (int i = 0; i < 32; i++) {
			sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					sum += 1;
				}
			}
			if (sum%3 == 1) {
				ans = ans | (1<<i);
			}
		}
		return ans;
    }
	
	public static void main(String []args)
	{
		int []nums = {1,1,1,5,5,5,6,6,6,3};
		SingleNumber2 sn2 = new SingleNumber2();
		System.out.println(" " + sn2.singleNumber(nums));
		
	}
}
