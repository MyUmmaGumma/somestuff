package teel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {
	public int findPairs(int[] nums, int k) {
		Set<Integer> m = new HashSet<>();
		Set<Integer> dup = new HashSet<>();
		int count = 0, K1 = 0, K2 = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if (k >= 0) { 
				K1 = (j + k);
				K2 = (j - k);
				if (!dup.contains(j)) {
					if (m.contains(K1) || m.contains(K2)) {
						count++;
						dup.add(j);
						if (m.contains(K1)) {
							dup.add(K1);
						} else {
							dup.add(K2);
						}
					}
				}
			} else {
				K1 = j - k;
				if (m.contains(K1) && !dup.contains(j)) {
					count++;
					dup.add(j);
				}
			}
			m.add(j);
		}
		return count;
    }
}
