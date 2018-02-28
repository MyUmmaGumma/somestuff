package teel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequene {
	/*public int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		Map<Integer, Integer> m = new HashMap<>();
		for (int j = 0 ; j < nums.length; j++) {
			int i = nums[j];
			int previ = nums[j]-1;
			int nexti = nums[j]+1;
			
			if (m.containsKey(i)) {
				continue;
			}
			boolean prev = m.containsKey(previ);
			boolean next = m.containsKey(nexti);
			if (prev && next) {
				int newv = 1 + m .get(previ) + m.get(nexti);
				m.put(i, newv);
				m.put(previ, newv);
				m.put(nexti, newv);
			} else if (prev == true) {
				int newv = 1 + m .get(previ);
				m.put(i, newv);
				m.put(previ, newv);
			} else if (next == true) {
				int newv = 1 + m .get(nexti);
				m.put(i, newv);
				m.put(nexti, newv);
			} else {
				m.put(i, 1);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i : m.values()) {
			max = Math.max(max, i);
		}
		return max;
    }*/
	private static int run = 0;
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
        		run++;
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                    System.out.println("Called " + run++);
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
	
	public static void main(String []args)
	{
		LongestConsecutiveSequene lcs = new LongestConsecutiveSequene();
		int []nums = {0,3,7,2,5,8,4,6,0,1};
		
		System.out.println(lcs.longestConsecutive(nums));
	}
}
