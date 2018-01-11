package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtree {
	Map<String, Integer> treeid; //gives each 'unique' string an id
	Map<Integer, Integer> count; // map an id to number of occurences
	List<TreeNode> ret;
	int t = 1;
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		treeid = new HashMap<String, Integer>();
		count = new HashMap<Integer, Integer>();
		ret = new ArrayList<TreeNode>();
		findDuplicates(root);
		return ret;
	}
	
	private int findDuplicates(TreeNode root)
	{
		if (root == null) return 0;
		
		String s = root.val + " "  + findDuplicates(root.left) + " "+ findDuplicates(root.right);
		int id = treeid.	computeIfAbsent(s, x-> t++);
		count.put(id, count.getOrDefault(id, 0) + 1); 
		if (count.get(id) == 2) {
			ret.add(root);
		}
		return id;
	}
}
