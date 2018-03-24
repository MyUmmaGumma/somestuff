package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EqualTreePartitionTest {

 	
	static TreeNode root = null;
	static BinaryTree lot = new BinaryTree();
	EqualTreePartition btb = new EqualTreePartition();
	
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
		btb.checkEqualTree(root);
	}

}
