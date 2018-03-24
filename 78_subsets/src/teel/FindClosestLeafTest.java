package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FindClosestLeafTest {

	FindClosestLeaf fcl = new FindClosestLeaf();
	static TreeNode root1 = null;
	static TreeNode root2 = null;
	static BinaryTree lot1 = new BinaryTree();
	static BinaryTree lot2 = new BinaryTree();
	
	@BeforeAll
	static void beforeAll()
	{
		int []nums = {8,5,3,1,4,6,10,7, 9, 11};
		for (int i = 0; i < nums.length;i++) {
			root1 = lot1.insert(nums[i], root1);
		}
		
	}
	@Test
	void test() {
		int val = fcl.findClosestLeaf(root1, 8);
		assertTrue(val == 9 || val == 11);
	}
	
	@Test
	void test7() {
		int val = fcl.findClosestLeaf(root1, 6);
		assertTrue(val == 7);
	}

}
