package teel;

import java.util.Collections;
import java.util.PriorityQueue;

public class ThirdMaximumInArray {
	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());
		for (int i = 0; i < nums.length;i++) {
			if (!pq.contains(nums[i])) { 
			  pq.add(nums[i]);
			}
		}
		if (pq.size() > 2) {
			pq.poll();pq.poll();
		}
		return pq.poll();
    }
	
	 public static void main(String []args)
	  {
		/* int []nums = {1,5,6,2,7,11,13,15,16,43,41,36,28,32};
		 ThirdMaximumInArray k = new ThirdMaximumInArray();
		 System.out.println(k.thirdMax(nums)); */
		 int []nums1 = {-2147483648, 1,1};
		 ThirdMaximumInArray k1 = new ThirdMaximumInArray();
		 System.out.println(k1.thirdMax(nums1));
	  }
}
