package teel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IsGraphBipartite {
	enum COLOR {
		RED, BLUE
	}
	
	private int findStart(int [][]graph, int []visited) 
	{
		//Find start vertex
		int start = -1;
		for(int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				start = i;
				break;
			}
		}
		return start;
	}
	
	public boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length ==0 ) { return false;}
		List<Integer> q = new LinkedList<>();
		int []visited = new int [graph.length];
		for (int i : visited) {
			visited[i] = 0;
		}
		
		Map<Integer, COLOR> m = new HashMap<>();
		
		int start = findStart(graph, visited);
		q.add(start);
		m.put(start, COLOR.RED);
		while (start != -1) {
			while(!q.isEmpty()) {
				int curr = q.remove(0);
				COLOR c = m.get(curr);
				int []neighbors = graph[curr];
				for (int n : neighbors) {
					if (visited[n] == 0) {
						if (m.containsKey(n)) {
							//If same color as current node return false;
							if (m.get(n) == c) {
								return false;
							}
						} else {
							//Add opposite color
							if (c == COLOR.RED) {
								m.put(n, COLOR.BLUE);
							} else {
								m.put(n, COLOR.RED);
							}
						}
						q.add(n);
					}
				}
				visited[curr] = 1;
			}
			start = findStart(graph, visited);
			m.put(start, COLOR.RED);
			q.add(start);
		}
		return true;
    }
	
	public static void main(String []args)
	{
		IsGraphBipartite gb = new IsGraphBipartite();
		int [][]graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}; //FALSE
		//int [][]graph = {{1, 3},{0, 2},{1, 3},{0, 2}}; //TRUE
		//int [][]graph = {{1}, {0}, {4},{4},{2,3}}; //TRUE
		/* [[2,4],[2,3,4],[0,1],[1],[0,1],[7],[9],[5],[],[6],[12,14],[],[10],[],[10],[19],[18],[],[16],[15],[23],[23],[],[20,21],
		 [],[],[27],[26],[],[],[34],[33,34],[],[31],[30,31],[38,39],[37,38,39],[36],[35,36],[35,36],[43],[],[],[40],
		 [],[49],[47,48,49],[46,48,49],[46,47,49],[45,46,47,48]] */
		System.out.println(gb.isBipartite(graph));
	}
}
