package teel;

import java.util.LinkedList;

public class CourseSchedule {
	enum Color {
		WHITE, GRAY, BLACK;
	};
	
	int time = 0;
	
	private boolean dfs_visit(int v, Color []color, int []pred, int []times, LinkedList<Integer> []edges)
	{
		time = time + 1;
		times[v] = time;
		color[v] = Color.GRAY;
		for (int i : edges[v]) {
			if (color[i] == Color.WHITE) {
				pred[i] = v;
				boolean res = 
					dfs_visit(i, color, pred, times, edges);
				if (res == false) {
					return false;
				}
			} else if (color[i] == Color.GRAY) {
				return false;
			}
		}
		color[v] = Color.BLACK;
		return true;
 	}
	
	LinkedList<Integer>[] convertToAdjList(int vertices, int [][]edges)
	{
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] lia = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			LinkedList<Integer> li = new LinkedList<Integer>();
			for (int j = 0; j < edges.length; j++) {
				if (edges[j][0] == i) {
					li.add(edges[j][1]);
				}
			}
			lia[i] = li;
		}
		return lia;
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Color []color = new Color [numCourses];
		int []pred = new int [numCourses];
		int []times = new int [numCourses];
		
		for (int i = 0; i < color.length; i++) {
			color[i] = Color.WHITE;
			pred[i] = Integer.MAX_VALUE;
		}
		LinkedList<Integer>[] lia = convertToAdjList(numCourses, prerequisites);
		for (int i = 0; i < numCourses; i++) {
			boolean res = true;
			if (lia[i].isEmpty()) 
				continue;
			if (color[i] == Color.WHITE) {
				 res = dfs_visit(i, color, pred, times, lia);
			}
			if (res == false) {
				return false;
			}
		}
		return true;
    }
	
	public static void main(String []args)
	{
		int numCourses = 2;
		int [][]edges = {{0,1}};
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(numCourses, edges));
	}
}
