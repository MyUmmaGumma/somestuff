package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pemutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(lli, new ArrayList<Integer>(), nums, new boolean [nums.length]);
        return lli;
    }
	
	void backtrack(List<List<Integer>> lli, List<Integer> li, int []nums, boolean []used)
	{
		if (li.size() == nums.length) {
			lli.add(new ArrayList<Integer>(li));
		} else {
			for (int i = 0; i < nums.length; i++)
			{
				if (used[i] || i > 0 && nums[i] == nums[i-1] && used[i-1] != true)	
					continue;
				
				li.add(nums[i]); used[i] = true;
				backtrack(lli, li, nums, used);
				used[i] = false;
				li.remove(li.size()-1);
			}
		}
	}

		
	public static void main(String []args)
	{
		Pemutations2 p2 = new Pemutations2();
		int []nums = {0,1};
		List<List<Integer>> lli = p2.permuteUnique(nums);
		for (List<Integer> li : lli) {
			for (Integer i : li) {
				System.out.print(i);
			}
			System.out.println("");
		}
	}
}
