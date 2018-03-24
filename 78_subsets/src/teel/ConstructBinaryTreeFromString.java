package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConstructBinaryTreeFromString {
	//Keep parsing the incoming string until you hit a number. once you 
	// get a number create a TreeNode and assign children
	// TRICK: 
	// 1. A node's two children will start with '(' within the same '('
	// 2. Since empty right child could be "" instead of (), check for
	//	  right child inside left child. Problem states that there is 
	//    always left child.
	private TreeNode str2tree_int(char []carr, int  []start)
	{
		StringBuilder sb = new StringBuilder();
		
		TreeNode root = null;
		
		
		while (start[0] < carr.length && carr[start[0]] != '(' && carr[start[0]] != ')') {
			sb.append(carr[start[0]]);
			start[0]++;
		}
		
		//We fall through 'if' here if there is no number at the start[0], we hit a ")("
		if (sb.length() != 0) {
			root = new TreeNode(Integer.parseInt(sb.toString()));
		}
		if (start[0] < carr.length && carr[start[0]] == '(') { 
			start[0]++;
			root.left = str2tree_int(carr, start);
			start[0]++;
			if (start[0] < carr.length && carr[start[0]] == '(') {
				start[0]++;
				root.right = str2tree_int(carr, start);
				start[0]++;
			}
		} 
		
		return root;
	}
	
	public TreeNode str2tree(String s) {
		//"4(2(3)(1))(6(5))"
		if (s.isEmpty()) return null;
		char []carr = s.toCharArray();
		int []start = new int [1];
		start[0] = 0;
		TreeNode dummy = str2tree_int(carr, start);
		return dummy;
    }
}
