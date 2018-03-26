package teel;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindCelebrity {
	private boolean knows(int i, int j) {
		return false;
	}
	 public int findCelebrity(int n) {
		for (int i = 0; i < n; i++) {
			int j = 0;
			for (; j < n; j++) {
				if (i != j) {
					if (knows(i, j)) {
						//i knows j
						break;
					}
					if (!knows(j, i)) {
						break;
					}
				}
			}
			if (j == n) {
				return i;
			}
		}
		return -1;
	 }
}
