package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MostFrequentSubtreeSum {
	HashMap<Integer, Integer> hm;
	private int sumTreePaths(TreeNode troot)
	{
		if (troot == null) {
			return 0;
		}
		int left = sumTreePaths(troot.left);
		int right = sumTreePaths(troot.right);
		int sum = troot.val + left + right;
		hm.computeIfAbsent(sum, x -> 1);
		hm.computeIfPresent(sum, (k,v)->v+1);
		return sum;
	}
	 public int[] findFrequentTreeSum(TreeNode root) {
	     hm = new HashMap<>();
	     sumTreePaths(root);
	     int max = 0;
	     ArrayList<Integer> ali = new ArrayList<>();
	     for (Entry<Integer, Integer> e : hm.entrySet()) {
	    	 	if (e.getValue() == max) {
	    	 		ali.add(e.getKey());
	    	 	} else if ((e.getValue() > max)) {
	    	 		ali.clear();
	    	 		ali.add(e.getKey());
	    	 		max = e.getValue();
	    	 	}
	     }
	     return ali.stream().mapToInt(i -> i).toArray();
	 }
}
