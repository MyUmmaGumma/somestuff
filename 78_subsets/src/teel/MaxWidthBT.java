package teel;

import java.util.HashMap;
import java.util.LinkedList;

public class MaxWidthBT {
	/*class AnnotatedNode {
		TreeNode t;
		AnnotatedNode(TreeNode x, boolean isnull) {
			t = x;
			isNull = isnull;
		}
		public boolean isNull;
	}
	
	public int widthOfBinaryTree(TreeNode root) {
        LinkedList<AnnotatedNode> ll = new LinkedList<>();
        if (root == null) {
        		return 0;
        }
        ll.add(new AnnotatedNode(root, false));
        int max = 1;
        while (!ll.isEmpty()) {
        		LinkedList<AnnotatedNode> q = new LinkedList<>();
        		int notnull = 0;
        		while (!ll.isEmpty()) {
        			AnnotatedNode t = ll.pop();
        			if (t.isNull == true) {
        				q.add(new AnnotatedNode(null, true));
        				q.add(new AnnotatedNode(null, true));
        			} else {
        				if (t.t.left == null) {
        					q.add(new AnnotatedNode(null, true));
        					
        				} else {
        					q.add(new AnnotatedNode(t.t.left, false));
        					notnull++;
        				}
        				if (t.t.right == null) {
        					q.add(new AnnotatedNode(null, true));
        			
        				} else {
        					q.add(new AnnotatedNode(t.t.right, false));
        					notnull++;
        				}
        			}
        			
        		}
        		if (notnull == 0) {
        			break;
        		}
        		int first = 0, last = 0;
        		for (int i = 0; i < q.size(); i++) {
        			if (q.get(i).isNull == false) {
        				first = i;
        				break;
        			}
        		}
        		for (int i = q.size() -1; i >= 0; i--) {
        			if (q.get(i).isNull == false) {
        				last = i;
        				break;
        			}
        		}
        		
        		max = Math.max(max, last - first + 1);
        		ll = q;
        }
        return max;
    } */

	
	public int widthOfBinaryTree(TreeNode root) {
		ans = 0;
		left = new HashMap<>();
		dfs(root, 0, 0);
		return ans;
	}
	int ans;
	HashMap<Integer, Integer> left;
	
	private void dfs(TreeNode root, int depth, int pos) {
		if (root == null) return;
		left.computeIfAbsent(depth, x -> pos);
		ans = Math.max(ans, pos - left.get(depth) + 1);
		dfs(root.left, depth + 1, pos*2);
		dfs(root.right, depth + 1, (pos*2) + 1);
		
	}
}
