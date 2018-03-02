package teel;

public class UnivalueSubtree {
	 private boolean isUnivalSubtree(TreeNode root, int num)
	 {
		 if (root.val == num) {
			 if (root.left != null && isUnivalSubtree(root.left, num) == false) { 
				 return false;
			 }
			 if (root.right != null && isUnivalSubtree(root.right, num) == false) { 
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 private int countUnivalSubtrees_int(TreeNode root, int num) {
		 int leftc = 0, rightc = 0; 
		 if (root.left != null) {
			 leftc = countUnivalSubtrees_int(root.left, root.left.val);
		 }
		 if (root.right != null) {
			 rightc = countUnivalSubtrees_int(root.right, root.right.val);
		 }
		
		 if  (root.val == num && isUnivalSubtree(root, num)) {
			 return leftc + rightc + 1;
		 }
		 return leftc + rightc; 
	 }
	 
	 public int countUnivalSubtrees(TreeNode root) {
		 if (root == null) {
			 return 0;
		 }
		 return countUnivalSubtrees_int(root, root.val);
	 }
}
