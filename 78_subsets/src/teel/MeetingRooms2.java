package teel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
	 public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, (a,b) -> Integer.compare(a.end, b.end));
		if (intervals.length == 0) return 0;
		if (intervals.length == 1) return 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int rooms = 1;
		int end = intervals[0].end;
		pq.add(end);
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < end) {
				if (!pq.isEmpty()) {
					if (pq.peek() > intervals[i].start) {
						pq.add(intervals[i].end);
						rooms++;
					} else {
						pq.remove();
					}
				} else {
					pq.add(intervals[i].end);
					rooms++;
				}
			} else {
				pq.remove();
				pq.add(intervals[i].end);
			}
			end = intervals[i].end;
		}
	     return rooms;
	 }
}
