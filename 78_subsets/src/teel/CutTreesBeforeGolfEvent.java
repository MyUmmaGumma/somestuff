package teel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CutTreesBeforeGolfEvent {
	private static final int []dx = {-1,1, 0, 0};
	private static final int []dy = {0,0, -1, 1};
	
	public int cutOffTree(List<List<Integer>> forest) {
		List<int []> trees = new ArrayList<>();
		
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(0).size(); j++) {
				int v = forest.get(i).get(j);
				if (v > 1) {
					trees.add(new int[] { i, j, v});
				}
			}
		}
		
		Collections.sort(trees, (a,b) -> Integer.compare(a[2], b[2]));
		
		int startx = 0, starty = 0, total = 0;
		for (int [] tree : trees) {
			int steps = traverse(startx, starty, tree[0], tree[1], forest);
			if (steps == -1) {
				return -1;
			}
			total += steps;
			startx = tree[0];
			starty = tree[1];
		}
		return total;
    }
	
	private int traverse(int startx, int starty, int destx, int desty, List<List<Integer>> forest)
	{
		List<int []> ll = new LinkedList<>();
		ll.add(new int [] {startx, starty, 0});
		
		boolean [][]visited = new boolean[forest.size()][forest.get(0).size()];
		visited[startx][starty] = true;
		
		while(!ll.isEmpty()) {
			int []tree = ll.remove(0);
			if (tree[0] == destx && tree[1] == desty) {
				return tree[2];
			}
			for (int i = 0; i < dx.length; i++) {
			
				int newr = tree[0] + dx[i];
				int newc = tree[1] + dy[i];
				
				if (newr >= 0 && newr < forest.size() &&
					newc >= 0 && newc < forest.get(0).size() && forest.get(newr).get(newc) > 0) {
					if (visited[newr][newc] == false) {
						ll.add(new int [] {newr, newc, tree[2]+1});
						visited[newr][newc] = true;
					}
				}
			}
		}
		return -1;
	}
}
