package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreaterThanTreeTest {
	TreeNode createTree(int []nums)
	{
		BinaryTree lotr = new BinaryTree();
		
		TreeNode root1 = null;
		for (int i = 0; i < nums.length;i++) {
			root1 = lotr.insert(nums[i], root1);
		}
		return root1;
	}
	
	void inorder(TreeNode root){
		if (root == null) {
			return ;
		} 
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	
	GreaterThanTree gtt = new GreaterThanTree();
	@Test
	void test() {
		int []nums = {8,5,3,4,6,7,10};
		TreeNode root1 = createTree(nums);
		gtt.convertBST(root1);
		inorder(root1);
	}

	@Test
	void test1() {
		int []nums = {1,0,-2,4,3};
		TreeNode root1 = createTree(nums);
		gtt.convertBST(root1);
		inorder(root1);
	}
}
