package teel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

public class ExclusiveTimeOfFunctions {
	/*
	 * n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
  
Output:[3, 4]s
	 */
	public int[] exclusiveTime(int n, List<String> logs) {
        //Map<Integer, Integer> map = new TreeMap<>();
        Stack<int []> logstk = new Stack<>();
        int []res = new int[n];
        int time=0, prev= 0;
        for (String log : logs) {
        		int id = Integer.valueOf (log.split (":") [0]);
        		time = Integer.valueOf (log.split (":") [2]);
        		if (log.contains("start")) {
        			if(!logstk.isEmpty()) {
        				logstk.peek()[1] += time - prev - 1;
        			}
        			logstk.push(new int [] {id, 1});
        		} else {
        			res[logstk.peek()[0]] += logstk.pop()[1] + (time - prev);
        		}
        		prev = time;
        }
        return res;
    }
}
