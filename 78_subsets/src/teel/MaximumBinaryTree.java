package teel;

public class MaximumBinaryTree {
	TreeNode dostuff(int []nums, int start, int end)
	{
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		int largest = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = start; i <= end; i++) {
			if (nums[i] > largest) {
				largest = nums[i];
				pos = i;
			}
		}
		TreeNode root = new TreeNode(largest);
		root.left = dostuff(nums, start, pos - 1);
		root.right = dostuff(nums, pos+1, end);
		return root;
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return dostuff(nums, 0, nums.length-1);
    }
}
