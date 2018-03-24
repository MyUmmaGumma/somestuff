package teel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class LineReflection {
	/* double getdiff(int x, int y)
	{
	    double difference = y - x;
	    double adDiff = difference/2;
	    return x + adDiff;
	}
	
	public boolean isReflected(int[][] points) {
		if (points.length <= 1) return true;
		
		HashMap<Integer, ArrayList<Integer>> hm  = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			ArrayList<Integer> li = null;
			if (hm.containsKey(points[i][1])) {
				 li = hm.get(points[i][1]);
                if (!li.contains(points[i][0]))
				li.add(points[i][0]);
			} else {
				 li = new ArrayList<>();
				li.add(points[i][0]);
				hm.put(points[i][1], li);
			}
			
		}
		double diff = Double.MAX_VALUE;
		for (Integer e : hm.keySet()) {
			ArrayList<Integer> li = hm.get(e);
			int j = li.size();
            
		
			Collections.sort(li);
			if (diff == Double.MAX_VALUE) {
				diff = getdiff(li.get(0), li.get(j-1));
			}
			if (j == 1) {
				if (li.get(0) != diff) {
					return false;
				}
			}
			
			for (int i = 0; i < j/2; i++) {
				if (Math.abs(li.get(i) - diff) != Math.abs(li.get(j -i -1)) - diff) {
					return false;
				}
			}
			if (j > 1  && ((j & 1) == 1)) {
				if (li.get(j/2) != diff) {
					return false;
				}
			}
		}
		return true;
    } */
	public boolean isReflected(int[][] points) {
		return false;
	}
}
