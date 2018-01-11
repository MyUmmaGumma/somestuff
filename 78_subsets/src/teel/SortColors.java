package teel;

public class SortColors {
	
    public void sortColors(int[] nums) {
    	int ones = 0, twos = 0, zeros = 0;
    	for (int i = 0; i < nums.length;i++) {
    		if (nums[i] == 0) {
    			zeros++;
    		} else if (nums[i] == 1) {
    			ones++;
    		} else if (nums[i] == 2) {
    			twos++;
    		}
    	}
    	int i = 0;
    	
    	for (; i < zeros;i++) {
    		nums[i] = 0;
    	}
    	
    	for (; i < zeros + ones;i++) {
    		nums[i] = 1;
    	}
    	
    	for (; i < zeros + ones + twos;i++) {
    		nums[i] = 2;
    	}
    	
    }
    
    public static void main(String []args) {
    	int []nums = {0,1,2,0,1,2,0,0};
    	SortColors sc = new SortColors();
    	sc.sortColors(nums);
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    }
}
