package teel;

import java.util.Arrays;
import java.util.LinkedList;

public class MinSizeSubarray {
	public int minSubArrayLen(int s, int[] nums) {
        
		Arrays.sort(nums);
		int running = 0;
		int smallest = 0;
		LinkedList<Integer> lir = new LinkedList<Integer>();
		LinkedList<Integer> li = new LinkedList<Integer>();
		
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > s) {
				break;
			} else if (nums[i] + running < s) {
				lir.add(nums[i]);
				running += nums[i];
			} else {
				if (li.isEmpty() || li.size() > lir.size()) {
					li.clear();
					li.addAll(lir);
				}
				j++;
				i = j;
				running = 0;
				lir.clear();
			}
		}
		return smallest;
	}
	
	public static void main(String args[])
	{
		int []nums= {2,3,1,4,3};
		MinSizeSubarray ms = new MinSizeSubarray();
		ms.minSubArrayLen(7, nums);
	}
}
