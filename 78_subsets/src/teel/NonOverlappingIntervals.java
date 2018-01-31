package teel;

import java.util.Arrays;

public class NonOverlappingIntervals {
	 class Interval {
		      int start;
		      int end;
		     Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}
	
	public int eraseOverlapIntervals(Interval[] intervals) {
		
		Arrays.sort(intervals, (a,b) -> (a.end == b.end) ? b.start - a.start : a.end - b.end);
		for (int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i].start + " , " + intervals[i].end);
		}
		int end = Integer.MIN_VALUE, remove = 0;
		for (Interval i : intervals) {
			if (end > i.start) {
				remove++;
				System.out.println("Need to remove " + i.start + " , " + i.end);
			} else {
				end = i.end;
			}
		}
		return remove;
    }
	
	public static void main(String []args)
	{
		NonOverlappingIntervals n = new NonOverlappingIntervals();
		NonOverlappingIntervals.Interval i = n.new Interval(0,8);
		NonOverlappingIntervals.Interval i1 = n.new Interval(0,3);
		NonOverlappingIntervals.Interval i2= n.new Interval(2,3);
		NonOverlappingIntervals.Interval i3 = n.new Interval(1,3);
		NonOverlappingIntervals.Interval i4 = n.new Interval(4,5);
		NonOverlappingIntervals.Interval i5 = n.new Interval(5,7);
		NonOverlappingIntervals.Interval i6 = n.new Interval(6,7);
		NonOverlappingIntervals.Interval []iarr = new Interval[8];
		iarr[0] = i; iarr[1] = i2; iarr[2] = i3;
		iarr[3] = i4; iarr[4] = i5; iarr[5] = i6;iarr[6] = i1;
		iarr[7] = n.new Interval(1,2);
		System.out.println(n.eraseOverlapIntervals(iarr));
	}
}
