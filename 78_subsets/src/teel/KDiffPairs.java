package teel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {
	public int findPairs(int[] nums, int k) {
		Set<Integer> diffpairs = new HashSet<>();
		Set<Integer> uniqs = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (uniqs.contains(nums[i] - k)) diffpairs.add(nums[i] - k);
			if (uniqs.contains(k + nums[i])) diffpairs.add(nums[i]);
			uniqs.add(nums[i]);
		}
		return diffpairs.size();
    }
}
