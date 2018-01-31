package teel;

public class SortedArrayToBST {
	private TreeNode sortedArrayToBST_int(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			TreeNode root = new TreeNode(nums[start]);
			root.left = root.right = null;
			return root;
		}
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST_int(nums, start, mid -1);
		root.right = sortedArrayToBST_int(nums, mid + 1, end);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST_int(nums, 0 , nums.length-1);
    }

	public void inorder(TreeNode node)
	{
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
 	}
	
	
	public static void main(String []args)
	{
		int []arr = {3,4,5,6,7,8,10};
		SortedArrayToBST s = new SortedArrayToBST();
		TreeNode root = s.sortedArrayToBST(arr);
		s.inorder(root);
	}
}
