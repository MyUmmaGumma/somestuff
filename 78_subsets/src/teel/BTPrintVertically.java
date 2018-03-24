package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BTPrintVertically {
	
	private void addAtLevel(TreeNode root, int level,  Map<Integer, List<Integer>> map)
	{
		if (root == null) {
			return;
		}
		List<Integer> atLevel = null;
		if (map.containsKey(level)) {
			atLevel = map.get(level);
		} else {
			atLevel = new ArrayList<Integer>();
			map.put(level, atLevel);
		}
		
		atLevel.add(root.val);
		addAtLevel(root.left, level - 1, map);
		addAtLevel(root.right, level + 1, map);
	}
	
	 public List<List<Integer>> verticalOrder(TreeNode root) {
	     List<List<Integer>> lli = new ArrayList<>();
	     Map<Integer, List<Integer>> map = new TreeMap<>();
	     addAtLevel(root, 0, map);
	     for (Entry<Integer, List<Integer>> e : map.entrySet()) {
	    	 	lli.add(e.getValue());
	     }
	     return lli;
	 }
}
