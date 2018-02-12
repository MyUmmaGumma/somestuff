package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CloneGraph {
	class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) 
		      {
		    	  	label = x; 
		    	  	neighbors = new ArrayList<UndirectedGraphNode>(); 
		    	  }
		 };

		 private  UndirectedGraphNode cloneGraph_int(UndirectedGraphNode node, 
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> seen) {
	        if (node == null) {
	            return null;
			}
	        if (seen.containsKey(node)) {
	            return seen.get(node);
	        }
	        
	        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
	        seen.put(node, res);
	        for (UndirectedGraphNode u : node.neighbors) {
				res.neighbors.add(cloneGraph_int(u, seen));
			}
	        
			return res;
	    }
	    
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if (node == null) {
				return null;
			}
			HashMap<UndirectedGraphNode, UndirectedGraphNode> seen = new HashMap<>();
			return cloneGraph_int(node, seen);
	    }
}
