package teel;

import java.util.PriorityQueue;

public class KthLargestArray {
	  public int findKthLargest(int[] nums, int k) {
		  if (nums.length == 1) {
			  return nums[0];
		  }
		  PriorityQueue<Integer> pq =
				  new PriorityQueue<Integer>((p,q) -> q- p);
		  
		  for (int i = 0; i < nums.length;i++) {
			  pq.add(nums[i]);
		  }
		  int last = 0;
		  for (int i = 0; i < k-1; i++) {
			  last = pq.poll();
		  }
		  
		  return (pq.size() == 0) ? last : pq.poll();
	  }
	  
	  public static void main(String []args)
	  {
		  KthLargestArray k = new KthLargestArray();
		  /*int []nums = {1,5,6,2,7,11,13,15,16,43,41,36,28,32};
		  System.out.println(k.findKthLargest(nums, 3));
		  System.out.println(k.findKthLargest(nums, 8));
		  */
		  int []nums1 = {1,2};
		  System.out.println(k.findKthLargest(nums1, 1));
	  }
}
