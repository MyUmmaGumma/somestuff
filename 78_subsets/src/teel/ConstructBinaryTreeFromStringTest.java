package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConstructBinaryTreeFromStringTest {

	ConstructBinaryTreeFromString cs = new ConstructBinaryTreeFromString();
	
	void inorder(TreeNode t)
	{
		if (t == null) return;
		inorder(t.left);
		System.out.println(t.val);
		inorder(t.right);
	}
	
	@Test
	void generaltest() {
		String s = "4(2(3)(1))(6(5))";
		TreeNode t = cs.str2tree(s);
		inorder(t);
	}

}
