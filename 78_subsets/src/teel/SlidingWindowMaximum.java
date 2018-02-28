package teel;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		boolean first  = true;
		
		int []ret = new int [nums.length - k+1];
		if (nums.length == 0) { return new int [0];}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i = 0, j =0; i < nums.length && j < nums.length; i++) {
			if (first == true) {
				first = false;
				for (int m = 0; m < k; m++) {
					pq.add(nums[m]);
				}
				ret[0] = pq.peek();
				pq.remove(nums[0]);
				if (pq.size() < k) {
					for (int i1 = 0; i1 < k - pq.size(); i1++) {
						pq.add(nums[0]);
					}
				}
				j = i+k;
				continue;
			}
			pq.add(nums[i+k-1]);
			pq.remove(nums[i-1]);
			if (pq.size() < k) {
				for (int i1 = 0; i1 < k - pq.size(); i1++) {
					pq.add(nums[i1-1]);
				}
			}
			ret[i] = pq.peek();
			j++;
        }
		return ret;
    }
	
	public static void main(String []args)
	{
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int []nums = {9,10,9,-7,-4,-8,2,-6};
		int []ret = swm.maxSlidingWindow(nums, 5);
		for (int i : ret) {
			System.out.println(i + " ");
		}
	}
}
