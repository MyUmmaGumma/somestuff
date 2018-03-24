package teel;

import java.util.Arrays;

public class MeetingRooms {
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (a,b) -> Integer.compare(a.end, b.end));
		if (intervals.length <= 1) return true;
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < intervals[i-1].end) 
				return false;
		}
		return true;
    }
}
