package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsWithDuplicates {
	 private  List<List<Integer>> perm(List<Integer> candidates,
			 int choose, 
			 Integer currlength,
			 List<Integer> orig,
			 List<List<Integer>> currLL)
	 {
		List<List<Integer>> llirec = new ArrayList<List<Integer>>();
		if (choose == 1) {
			
			for (int i = 0; i < candidates.size(); i++) {
				List<Integer> li = new ArrayList<Integer>();
				li.add(candidates.get(i));
				llirec.add(li);
			}
			return llirec;
		} else {
			llirec = perm(candidates, choose - 1, currlength, orig, currLL);
			currLL = new ArrayList<List<Integer>>();;
			for (List<Integer> l : llirec) {
				List<Integer> newc = new ArrayList<Integer>();
				//Create new list of candidates for a position
				newc.addAll(orig);
				// Need to remove all the ones that are used in this list
				int toRemove = l.size();
				for (int i = 0; i < candidates.size() && toRemove > 0; i++) {
					if (l.contains(candidates.get(i))) {
						newc.remove(candidates.get(i));
						toRemove--;
					}
				} 
				for (int i = 0; i < newc.size(); i++) {
					List<Integer> li = new ArrayList<Integer>();
					li.addAll(l);
					li.add(newc.get(i));
					if (!currLL.contains(li)) {
						currLL.add(li);
					}
				}
			}
			return currLL;
		}
	 }
	 
	 public List<List<Integer>> permuteUnique(int[] nums) {
		 //List<List<Integer>> lli = new HashSet<List<Integer>>();
		 List<List<Integer>> alli = new ArrayList<List<Integer>>();
		 if (nums.length == 0) {
			 return alli;
		 }
		 List<Integer> li = new ArrayList<Integer>();
		 for(int i = 0; i < nums.length ; i++) {
			 li.add(nums[i]);
		 }
		 
		 List<List<Integer>> hs = perm(li, nums.length, 0, li, alli);
		 
		 return hs;
	 }
	 
	 public static void main(String []args)
	 {
		 PermutationsWithDuplicates p = new PermutationsWithDuplicates();
		 int []a = {1,1,2};
		 List<List<Integer>> lli = p.permuteUnique(a);
		 for (List<Integer> li : lli) {
			 for (Integer i : li) {
				 System.out.print(i + " ");
			 }
			 System.out.println();
		 }
	 }
}
