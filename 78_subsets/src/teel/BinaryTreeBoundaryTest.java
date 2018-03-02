package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinaryTreeBoundaryTest {
	 	
	static TreeNode root = null;
	static BinaryTree lot = new BinaryTree();
	BinaryTreeBoundary btb = new BinaryTreeBoundary();
	
	@BeforeAll
	static void beforeAll()
	{
		int []nums = {8,5,3,1,4,6,10,7, 9, 11};
		for (int i = 0; i < nums.length;i++) {
			root = lot.insert(nums[i], root);
		}
	}
	
	
	@Test
	void test() {
		List<Integer> li = btb.boundaryOfBinaryTree(root);
		int []nums = {8,5,3,1,4,7,11,10};
		for (int i : nums) {
			assertTrue(li.contains(i) == true);
		}
	}
	
	TreeNode createTree(int []nums)
	{
		BinaryTree lotr = new BinaryTree();
		
		TreeNode root1 = null;
		for (int i = 0; i < nums.length;i++) {
			root1 = lotr.insert(nums[i], root1);
		}
		return root1;
	}

	@Test
	void testLeftOnly() {
		int []nums = {1,2,3};
		TreeNode root1 = createTree(nums);
		List<Integer> li = btb.boundaryOfBinaryTree(root1);
		int []nums1 = {1,2,3};
		for (int i : nums1) {
			assertTrue(li.contains(i) == true);
		}
	}

	@Test
	void testTwoNodes() {
		int []nums = {1,2};TreeNode root1 = createTree(nums);
		List<Integer> li = btb.boundaryOfBinaryTree(root1);
		int []nums1 = {1,2};
		for (int i : nums1) {
			assertTrue(li.contains(i) == true);
		}
	}
	
	@Test
	void testOnlyRoot() {
		int []nums = {1};TreeNode root1 = createTree(nums);
		List<Integer> li = btb.boundaryOfBinaryTree(root1);
		int []nums1 = {1};
		for (int i : nums1) {
			assertTrue(li.contains(i) == true);
		}
	}
}
