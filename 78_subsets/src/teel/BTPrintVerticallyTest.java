package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BTPrintVerticallyTest {

	
	static TreeNode root = null;
	static BinaryTree lot = new BinaryTree();
	BTPrintVertically btb = new BTPrintVertically();
	
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
		List<List<Integer>> lli = btb.verticalOrder(root);
		int []nums = {8,5,3,1,4,7,11,10};
		for (List<Integer> li : lli) {
			for (Integer i : li) {
				System.out.print(i);
			}
		}
	}

}
