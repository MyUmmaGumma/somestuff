package teel;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>(n);
		for (int i= 0; i < n; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		boolean []visited = new boolean[n];
		if (hasCycle(adjList, visited, 0, -1)) {
			return false;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] == true) return false;
		}
		return true;
    }
	
	private boolean hasCycle(List<List<Integer>> adjList,  boolean []visited, int u, int parent)
	{
		/*visited[start] = true;
		List<Integer> neigbors = adjList.get(start);
		for (Integer n : neigbors) {
			if (n != parent && visited[n] == true) {
				return true;
			}
			if (visited[n] == false) {
				return hasCycle(adjList, visited, n, start);
			}
		}
		return false; */
		 visited[u] = true;
	        
	        for (int i = 0; i < adjList.get(u).size(); i++) {
	            int v = adjList.get(u).get(i);
	            
	            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList,  visited, v, u)))
	                return true;
	        }
	        
	        return false;
	}
}
