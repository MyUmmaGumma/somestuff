package teel;

import java.util.HashMap;

public class EqualTreePartition {
	
	private int sumTreePaths(TreeNode troot, HashMap<TreeNode, Integer> rootedSum)
	{
		if (troot == null) {
			return 0;
		}
		int left = sumTreePaths(troot.left, rootedSum);
		int right = sumTreePaths(troot.right, rootedSum);
		rootedSum.put(troot, troot.val + left + right);
		return  troot.val + left + right;
	}
	
	private boolean walkTree(TreeNode troot, int targetSum, HashMap<TreeNode, Integer> rootedSum)
	{
		if (troot == null) {
			return false;
		}
		int root_right = 0, root_left = 0;
		if (troot.right != null) {
			root_right = rootedSum.get(troot.right);
		}
		if (troot.left != null) {
			root_left = rootedSum.get(troot.left);
		}
		return walkTree(troot.left, root_right + troot.val, rootedSum) ||
				walkTree(troot.right, root_left + troot.val, rootedSum);
	}
	
	public boolean checkEqualTree(TreeNode root) {
		HashMap<TreeNode, Integer> rootedSum = new HashMap<>();
		TreeNode troot = root;
		int sum = sumTreePaths(troot,rootedSum);
		return sum%2 == 0 && rootedSum.containsValue(sum/2);
		//return walkTree(troot, 0, rootedSum);
    }
	/*
	 * Alternate solution - not mine
	 * 
	 * 1. check the sum of entire tree, if it isn’t a multiple of 2 return false;
	 * 2. if the tree can be divided into two equal trees, then there must be a node other 
		than root with which we can build a subtree and the sum of it would be half of the 
		sum of the entire tree.
	 * public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root);
        if(sum % 2 != 0) return false;
        
        return checkEqualTree(sum / 2, root.left) || checkEqualTree(sum / 2, root.right);
    }
    
    private boolean checkEqualTree(int target, TreeNode root){
        if(root == null) return false;
        return target == sum(root) || 
            (target == sum(root.left) && root.left != null) || 
            (target == sum(root.right) && root.right != null) ||
            checkEqualTree(target, root.left) || checkEqualTree(target, root.right);
    }
    
    public int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    
	 */
}
