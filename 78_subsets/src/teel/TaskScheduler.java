package teel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int []c = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			c[tasks[i]]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue(26, Collections.reverseOrder());
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 0) {
				pq.add(c[i]);
			}
		}
		int steps = 0;
		while (!pq.isEmpty()) {
			
			List<Integer> temp= new ArrayList<>();
			int i = 0;
			while (i <= n) {
				if (!pq.isEmpty()) {
					int num = pq.peek();
					if (num > 1) {
						temp.add(pq.poll() - 1);
					} else {
						pq.poll();
					}
				}
				steps++;
				if (pq.isEmpty() || temp.size() == 0) {
					break;
				}
				i++;
			}
			for (Integer j : temp) {
				pq.add(j);
			}
		}
		return steps;
    }
}
