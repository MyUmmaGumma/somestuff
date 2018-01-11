package teel;

import java.util.StringTokenizer;

public class Codec_Serializer_Deserializer {

	private void serialize_int(TreeNode root, StringBuilder s)
	{
		if (root == null) {
			s.append(" null");
			return;
		} else {
			
			s.append(' ');
			s.append(Integer.toString(root.val));
			serialize_int(root.left, s);
			serialize_int(root.right, s);
		}
	}
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder s = new StringBuilder();
    	serialize_int(root, s);
    	return s.toString();
    }
    
    private TreeNode deserialize_int(StringTokenizer st)
    {
    	if (st.hasMoreTokens()) {
    		TreeNode root;
    		String s = st.nextToken();
    		if (s.contentEquals("null")) {
    			root = null;
    		} else {
    			root = new TreeNode(Integer.parseInt(s));
    			root.left = deserialize_int(st);
    			root.right = deserialize_int(st);
    		}
    		return root;
    	}
    	return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	StringTokenizer st = new StringTokenizer(data);
    	TreeNode root = null;
    	root = deserialize_int(st);
    	return root;
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
	
	public void printNode(TreeNode t)
	{
		if (t == null) {
			System.out.println("null ");
		} else {
			System.out.println(t.val + " ");
			printNode(t.left);
			
			printNode(t.right);
		}
	}
	
    public static void main(String []args)
    {
    	Codec_Serializer_Deserializer csd = new Codec_Serializer_Deserializer();
    	int []a = {8,5,3,4,6,10,7};
		TreeNode root = null;
		
		for (int i = 0; i < a.length;i++) {
			root = csd.insert(a[i], root);
		}
		System.out.println(csd.serialize(root));
		String s = csd.serialize(root);
		TreeNode t = csd.deserialize(s);
		csd.printNode(t);
    }
}
