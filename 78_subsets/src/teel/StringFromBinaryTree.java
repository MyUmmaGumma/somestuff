package teel;

public class StringFromBinaryTree {
	private String tree2str_int(TreeNode t, StringBuilder sb)
	{
		if (t == null) {
			return ""; 
		}
		sb.append(Integer.toString(t.val));
		tree2str_int(t.left, sb.append('('));
		sb.append(')');
		tree2str_int(t.right, sb.append('('));
		sb.append(')');
		return sb.toString();
	}
	
	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		String res = tree2str_int(t, sb);
		//These are to avoid unneceesary brackets
		res = res.replaceAll("\\(\\)\\(\\)", "");
		res = res.replaceAll("\\(\\)\\)", ")");
        if (res.endsWith("()")) {
			res = res.substring(0, res.length()-2);
		}
		return res;
    }
	
	private TreeNode newTreeNode(int num)
	{
		TreeNode newnode = new TreeNode(num);
		newnode.left = newnode.right = null;
		return newnode;
	}
	
	private TreeNode insert(int num, TreeNode root)
	{
		TreeNode newNode = newTreeNode(num);
		if (root == null) {
			root = newNode;
			return root;
		}
		if (root.val < num) {
			root.right = insert(num, root.right);
		} else {
			root.left = insert(num, root.left);
		}
		return root;
	}
	
	
	public static void main(String []args)
	{
		StringFromBinaryTree sfbt = new StringFromBinaryTree();
		int []a = {8,5,3,4,6,10,7};
		TreeNode root = null;
		
		for (int i = 0; i < a.length;i++) {
			root = sfbt.insert(a[i], root);
		}
		
		System.out.println(sfbt.tree2str(root));
	}
}
