package teel;

public class FirstMissingPositive {
	private int findSmallest(int[] nums)
	{
		int smallest = Integer.MAX_VALUE;
		for(int i =0; i < nums.length; i++) {
			if (nums[i] >= 0 && nums[i] < smallest) {
				smallest = nums[i];
			}
		}
		return smallest;
	}
	
	private int findLargest(int []nums) {
		int largest = Integer.MIN_VALUE;
		for(int i =0; i < nums.length; i++) {
			if (nums[i] >= 0 && nums[i] > largest) {
				largest = nums[i];
			}
		}
		return largest;
	}
	
	public int[] counts(int []nums, int largest)
	{
		int []c = new int[largest];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				c[nums[i]-1] += 1;
			}
		}
		return c;
	}
	
	public int firstMissingPositive(int[] nums) {
		int largest = findLargest(nums);
		int []c = counts(nums, largest);
		for (int i = 0; i < largest; i++) {
			if (c[i] == 0) {
				return i+1;
			}
		}
		return largest + 1;
    }
	
	public static void main(String []args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int []nums = {3,4,-1,1};
		System.out.println("The missing number is " + fmp.firstMissingPositive(nums));
		int []nums1 = {1,2,0};
		System.out.println("The missing number is " + fmp.firstMissingPositive(nums1));
	}
}
