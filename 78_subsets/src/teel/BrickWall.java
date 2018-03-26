package teel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	 public int leastBricks(List<List<Integer>> wall) {
		 Map<Integer, Integer> m = new HashMap<>();
		 int frequent = 0;
		 for (List<Integer> li : wall) {
			 int sum = 0;
			 for (Integer i : li) {
				 
				 sum += i;
				 if (m.containsKey(sum)) {
					 int j = m.get(i);
					 m.put(sum, j+1);
				 } else {
					 m.put(sum, 1);
				 }
				 frequent = Math.max(frequent, m.get(sum));
			 }
		 }
		 return frequent - wall.get(0).size();
	 }
}
