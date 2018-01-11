package teel;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	 private  List<List<Integer>> perm(List<Integer> candidates,
			 int position, 
			 int length,
			 int []nums,
			 List<List<Integer>> lli)
	 {
		if (position == length) {
			return lli;
		}
		List<List<Integer>> llirec = new ArrayList<List<Integer>>();
		for (List<Integer> li : lli) {
			List<Integer> newcandidates = new ArrayList<Integer>();
			for(Integer k : candidates) {
				if (!li.contains(k)) {
					newcandidates.add(k);
				}
			}
			
			for(Integer j : newcandidates) {
				List<Integer> newlist = new ArrayList<Integer>();
				newlist.addAll(li);
				newlist.add(position, j);
				llirec.add(newlist);
			}
		}
		
		lli = perm(candidates, position + 1, length, nums, llirec);
		
		return lli;
		
		
		/* for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> llirec = new ArrayList<List<Integer>>();
			perm(candidates, position + 1, length - 1, nums, llirec);
			for (List<Integer> li : llirec) {
				for(Integer j : candidates) {
					if (!li.contains(j)) {
						li.add(j);
						lli.add(li);
					}
				}
			}
		}*/
		
	 }
	 	
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> lli = new ArrayList<List<Integer>>();
		 if (nums.length == 0) {
			 return lli;
		 }
		 List<Integer> li = new ArrayList<Integer>();
		 for(int i = 0; i < nums.length ; i++) {
			 li.add(nums[i]);
		 }
		 for (int i = 0 ; i < nums.length; ++i) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(0, nums[i]);
				lli.add(l);
		 }
		 return perm(li, 1, nums.length, nums, lli);
		 
	 }
	 
	 public static void main(String []args)
	 {
		 Permutations p = new Permutations();
		 int []a = {1,2,3};
		 List<List<Integer>> lli = p.permute(a);
		 for (List<Integer> li : lli) {
			 for (Integer i : li) {
				 System.out.print(i + " ");
			 }
			 System.out.println();
		 }
	 }
}
