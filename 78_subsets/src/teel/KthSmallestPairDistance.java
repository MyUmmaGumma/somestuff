package teel;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue();
		for (int i = 0; i < nums.length;i++) {
			for (int j = i + 1; j < nums.length;j++) {
				pq.add(Math.abs(nums[i] - nums[j]));
			}
		}
		return 0;
	}
	
	
	public static void main(String []args)
	{
		int []arr = {1,3,4,5,8,11,14,2,6};
		KthSmallestPairDistance kspd = new KthSmallestPairDistance();
		kspd.smallestDistancePair(arr, 3);
	}
}
