package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubtreeOfAnotherTreeTest {
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
	@Test
	void test1() {
		int []nums = {8,5,3,4,6,7,10};
		TreeNode root1 = createTree(nums);
		int []t = {3,4};
		TreeNode troot = createTree(t);
		SubtreeOfAnotherTree st = new SubtreeOfAnotherTree();
		assertTrue(st.isSubtree(root1, troot));
	}
	
	@Test
	void test2() {
		int []nums = {8,5,3,4,6,7,10};
		TreeNode root1 = createTree(nums);
		int []t = {5,3,4,6,7};
		TreeNode troot = createTree(t);
		SubtreeOfAnotherTree st = new SubtreeOfAnotherTree();
		assertTrue(st.isSubtree(root1, troot));
	}

	@Test
	void test3() {
		int []nums = {8,5,3,4,6,7,10};
		TreeNode root1 = createTree(nums);
		int []t = {5,3,4,6,8};
		TreeNode troot = createTree(t);
		SubtreeOfAnotherTree st = new SubtreeOfAnotherTree();
		assertFalse(st.isSubtree(root1, troot));
	}
	
	@Test
	void test4() {
		int []nums = {10,5,15,1,12};
		int []t = {10,1,12};
		TreeNode root1 = createTree(nums);
		
		TreeNode troot = createTree(t);
		SubtreeOfAnotherTree st = new SubtreeOfAnotherTree();
		assertFalse(st.isSubtree(root1, troot));
	}
	
}
