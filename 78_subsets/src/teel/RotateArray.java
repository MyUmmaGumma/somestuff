package teel;

public class RotateArray {
	//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	private static void reverse(int []nums ,int start, int end)
	{
		int temp;
		
		while (start <= end) {
			temp = nums[start];
			nums[start] = nums [end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public void rotate(int[] nums, int k) {
		
		if (nums.length <= 1 || nums.length == k || k == 0) {
			return;
		}
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		
    }
	
	public static void main(String []args)
	{
		RotateArray ra = new RotateArray();
		int []nums = {1,2,3,4,5,6,7};
		ra.rotate(nums, 3);
		for (int i : nums)
			System.out.print(i + " ");
	}
}
