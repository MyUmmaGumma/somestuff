package teel;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence2ndTry {
	 private  List<List<Integer>> perm(List<Integer> candidates,
			 int choose, 
			 Integer currlength,
			 List<Integer> orig,
			 List<List<Integer>> currLL)
	 {
		List<List<Integer>> llirec = new ArrayList<List<Integer>>();
		if (choose == 1) {
			int chosen = 0;
			for (int i = 0; i < candidates.size(); i++) {
				List<Integer> li = new ArrayList<Integer>();
				do {
					li.add(candidates.get(i));
					chosen++;
					currlength++;
				} while (chosen < choose);
				llirec.add(li);
			
			}
			return llirec;
		} else {
			llirec = perm(candidates, choose - 1, currlength, orig, currLL);
			List<Integer> newc = new ArrayList<Integer>();
			newc.addAll(orig);
			for (List<Integer> l : llirec) {
				for (int i = 0; i < candidates.size(); i++) {
					if (!l.contains(candidates.get(i))) {
						newc.remove(candidates.get(i));
					}
				}
				for (int i = 0; i < newc.size(); i++) {
					List<Integer> li = new ArrayList<Integer>();
					li.addAll(l);
					li.add(candidates.get(i));
					if (!currLL.contains(li)) {
						currLL.add(li);
					}
				}
			}
			return currLL;
		}
	 }
	 	
	 public String permute(int[] nums, int k) {
		 List<List<Integer>> lli = new ArrayList<List<Integer>>();
		 if (nums.length == 0) {
			 return null;
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
		 //lli = perm(li, 1, nums.length, nums, lli);
		 List<Integer> lil = lli.get(k);
		 String s = "";
		 for (Integer i : lil) {
			 s += i.toString();
		 }
		 return s;
	 }
	 
	 public String getPermutation(int n, int k) {
		 if (n <= 0 || k < 0) {
			 return "";
		 }
		 int []nums = new int[n];
		 for (int i = 1; i <= n; i++) {
			 nums[i-1] = i;
		 }
		 return permute(nums, k);
	 }
	 
	 public static void main(String []args)
	 {
		 PermutationSequence2ndTry p = new PermutationSequence2ndTry();
		
		 System.out.println(p.getPermutation(5, 32));
	 }
}
