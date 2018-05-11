package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	/*Set<String> ss = new HashSet<String>();
	
	public class TwoInteger {
		Integer i1;Integer i2; Integer i3; String unique;
		TwoInteger(int i, int j, int k) {
			if (i > j) {
				if (i > k && j > k) {
					i1 = i; i2= j; i3 = k; 
				} else if (i > k && j <= k) {
					i1 = i; i2= k; i3 = j;
				} else {
					i1 = k; i2 = i; i3 = j;
				}
			} else {
				if (j > k && i > k) {
					i1 =j; i2= i; i3 = k; 
				} else if (j > k && i <= k) {
					i1 = j; i2= k; i3 = i;
				} else {
					i1 = k; i2 = j; i3 = i;
				}
				
			}
			unique = i1 + " " + i2 + " " + i3;
		}
		@Override
		public boolean equals(Object o) {
		    // self check
		    if (this == o)
		        return true;
		    // null check
		    if (o == null)
		        return false;
		    // type check and cast
		    if (getClass() != o.getClass())
		        return false;
		    TwoInteger person = (TwoInteger) o;
		    // field comparison
		    return person.unique.contentEquals(unique);
		}
	}
		
	public List<TwoInteger> twoSum(int []nums, int sum, int used)
	{
		Map<Integer, Integer> twosum = new HashMap<Integer, Integer>();
		List<TwoInteger> li = new ArrayList<TwoInteger>();

		for (int i = 0; i < nums.length; i++) {
			if (i == used) {
				continue;
			}
			if (twosum.containsKey(sum - nums[i])) {
				TwoInteger two = new TwoInteger(nums[i], sum - nums[i], (-1 * sum));
				if (!li.contains(two) && !ss.contains(two.unique)) {
					li.add(two);
					ss.add(two.unique);
				}
			}
			twosum.put(nums[i], i);
		}
		return li;
	}
	
	public List<List<Integer>> threeSum(int []nums)
	{
		List<List<Integer>> lli = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return lli;
		}
		
		
		
		for (int i = 0; i < nums.length; i++) {
			List<TwoInteger> li2 = twoSum(nums, (-1) * (nums[i]), i);
			if (!li2.isEmpty()) {
				for (TwoInteger two : li2) { 
					List<Integer> li = new ArrayList<Integer>();
					li.add(two.i1);
					li.add(two.i2);
					li.add(two.i3);
					lli.add(li);
				}
			}
		}
		return lli;
	} */
	
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lli = new ArrayList<List<Integer>>();
		if (nums.length <= 2) {
			return lli;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i - 1 >= 0 && nums[i] == nums[i-1]) {
				continue;
			}
			
			int lo = i + 1, hi = nums.length -1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum == 0) {
					lli.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					//Remove duplicates
					while (lo + 1 < hi && nums[lo] == nums[lo+1]) {
						lo++;
					}
					while (lo < hi-1 && nums[hi] == nums[hi-1]) {
						hi--;
					}
					lo++;
					hi--;
				} else if (sum < 0) {
					lo++;
				} else if (sum > 0) {
					hi--;
				}
			}
		}
		
		return lli;
    }
	
	public static void main(String []args)
	{
		int []nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>>lli = ts.threeSum(nums);
		for (List<Integer> li : lli) {
			for(Integer i : li) {
				System.out.print(i);
				System.out.print(',');
			}
			System.out.println();
		}
	}
}
