import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Solution {

	
	private Interval resultSet(List<Interval> intervals, int edge, boolean leftright, List<Interval> resultSet)
	{
		
			
			Interval ret = new Interval();
			if (leftright) {
				for(int i = 0; i < intervals.size();i++) {
					Interval j = intervals.get(i);
					if (edge > j.end) {
						resultSet.add(j);
					} else {
						return j;
					}
				}
			} else {
				for(int i = intervals.size()-1;i >= 0; i--) {
					Interval j = intervals.get(i);
					if (edge < j.start) {
						resultSet.add(j);
					} else {
						return j;
					}
				}
			}
			return ret;
		}
		
		private Interval 
		resolveIntervals(Interval i1, Interval i2, Interval newInterval)
		{
			Interval ret = new Interval();
			if (newInterval.end >= i1.start && newInterval.end <= i1.end) {
				if (newInterval.start >= i1.start) {
					ret.start = i1.start; ret.end = i1.end;
				} else if (newInterval.start < i1.start) {
					ret.start = newInterval.start;
				}
				if (newInterval.end < i1.end) {
					ret.end = i1.end;
				} else {
					ret.end = newInterval.end;
				}
			} else if (newInterval.end >= i1.start && newInterval.end > i1.end) {
				if (newInterval.end >= i2.start && newInterval.end <= i2.end) {
					ret.start = i1.start; ret.end = i2.end;
				} else if (newInterval.start >= i2.start && newInterval.end > i2.end) {
					if (newInterval.start > i2.end) {
						ret.start = newInterval.start; ret.end = newInterval.end;
					} else {
						ret.start = i2.start; ret.end = newInterval.end;
					}
				}
			} else if (newInterval.start < i1.start) {
				if (newInterval.end < i1.end) {
					ret.start = newInterval.start; ret.end = i1.end;
				} else if (newInterval.end > i1.end) {
					if (newInterval.end < i2.start) {
						ret.start = newInterval.start; ret.end = newInterval.end;
					} else if (newInterval.end < i2.end) {
						ret.start = newInterval.start; ret.end = i2.end;
					}
				}
			}
			return ret;
		}
		public boolean overlap(Interval i1, Interval i2) 
		{
			if (i1.end < i2.start) {
				return false;
			} 
			return true;
		}
		
	    public List<Interval> merge(List<Interval> intervals) {
	    	if (intervals.isEmpty()) {
	    		return intervals;
	    	}
	    	
	    	intervals.sort(new Comparator<Interval>() {
	    		public int compare(Interval i1, Interval i2) {
	    			if (i1.start > i2.start) {
	    				return 1;
	    			} else if (i1.start == i2.start) {
	    				if (i1.end == i2.end) {
	    					return 0;
	    				} else if (i1.end < i2.end) { 
	    					return 1;
	    				} else {
	    					return -1;
	    				}
	    			} else {
	    				return -1;
	    			}
	    		}
	    	});
	    	
	    	Interval src = intervals.get(0);
	    	for (int j = 1; j < intervals.size();) {
	    		Interval target = intervals.get(j);
	    		if (overlap(src, target)) {
	    			src.start = Math.min(src.start, target.start);
	    			src.end = Math.max(src.end, target.end);
	    			intervals.remove(j);
	    		} else {
	    			j++;
	    			src = target;
	    		}
	    	}
	    	
	    	return intervals;
	    }
		
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> ret = new ArrayList<Interval>();
	        if (intervals.isEmpty()) {
	        	 ret.add(newInterval);
	        	 return ret;
	        }
	        List<Interval> mainset = new ArrayList<Interval>();
	        Interval i1 = resultSet(intervals, newInterval.start, true, mainset);
	        Interval i2 = resultSet(intervals, newInterval.end, false, mainset);
	        for (Interval i : mainset) {
	        	//i.print();
	        }
	        Interval i3 = resolveIntervals(i1, i2, newInterval);
	        mainset.add(i3);
	        /*i1.print(); i2.print(); */
	        for (Interval i : merge(mainset)) {
	        	i.print();
	        } 
	        return merge(mainset);
	    }
	
	public static void main(String []args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		Solution s = new Solution();
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1,5));
		//l.add(new Interval(6,9));
		//l.add(new Interval(6,7));
		//l.add(new Interval(8,10));
		//l.add(new Interval(1,2));
		//l.add(new Interval(1,2));
		//l.add(new Interval(12,16));
		Interval i = new Interval(0,0);
		s.insert(l, i);
	}
}
