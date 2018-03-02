package teel;

public class UnivalueLongestPath {
	public int longestUnivaluePath_int(TreeNode root, int []res) {
		 int leftc = 0, rightc = 0; 
		 if (root.left != null) {
			 leftc = longestUnivaluePath_int(root.left, res);
		 }
		 if (root.right != null) {
			 rightc = longestUnivaluePath_int(root.right, res);
		 }
		
		 int lres = 0, rres = 0;
	 	 if (root.left != null && root.left.val == root.val) {
			  lres = leftc + 1;
		 }
		 if (root.right != null && root.right.val == root.val) {
			 rres = rightc + 1;
		 }
		 res[0] = Math.max(res[0], lres + rres);

		 //Store max value if adding the left and right
		 // At each node return max of left result and right result
		 return Math.max(lres, rres); 
    }
	
	public int longestUnivaluePath(TreeNode root) {
		 if (root == null) {
			 return 0;
		 }
		 int []res = new int[1];
		 longestUnivaluePath_int(root, res);
		 return res[0];
    }
}
