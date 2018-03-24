package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaxWidthBTTest {

	static TreeNode root = null;
	static BinaryTree lot = new BinaryTree();
	MaxWidthBT mwbt = new MaxWidthBT();
	
	@BeforeAll
	static void beforeAll()
	{
		int []nums = {8,5,3,1,4,6,10,7, 9, 11};
		for (int i = 0; i < nums.length;i++) {
			root = lot.insert(nums[i], root);
		}
	}
	
	@Test
	void test1() {
		assertTrue(mwbt.widthOfBinaryTree(root) == 4);
	}
	
	@Test
	void test2() {
		root = lot.insert(20, root);
		assertTrue(mwbt.widthOfBinaryTree(root) == 8);
	}

	@Test
	void test3() {
		 TreeNode root1 = null;
		 BinaryTree lot1 = new BinaryTree();
		root1 = lot1.insert(20, root1);
		root1 = lot1.insert(10, root1);
		root1 = lot1.insert(5, root1);
		root1 = lot1.insert(15, root1);
		assertTrue(mwbt.widthOfBinaryTree(root1) == 2);
	}

	@Test
	void SingleNode() {
		 TreeNode root1 = null;
		 BinaryTree lot1 = new BinaryTree();
		root1 = lot1.insert(20, root1);
		
		assertTrue(mwbt.widthOfBinaryTree(root1) == 1);
	}
}
