package teel;

public class ProductOfArray {
	public int[] productExceptSelf(int[] nums) {
		int []mem1 = new int [nums.length];
		int []mem2 = new int [nums.length];
		int running = 1;
		for (int i = 0; i < nums.length; i++) {
			mem1[i] = (i == 0) ? running : nums[i-1]*running;
			running = mem1[i];
		}
		running = 1;
		for (int i = nums.length - 1; i >= 0;  i--) {
			mem2[i] = (i == nums.length - 1) ? running : nums[i+1]*running;
			running = mem2[i];
		}
		int []res = new int [nums.length];
		for (int i = 0; i < nums.length;  i++) {
			res[i] = mem1[i] * mem2[i];
		}
		return res;
    }
	
	public static void main(String []args)
	{
		ProductOfArray poa = new ProductOfArray();
		int []nums = {1,2,3,4};
		
		int []res = poa.productExceptSelf(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
