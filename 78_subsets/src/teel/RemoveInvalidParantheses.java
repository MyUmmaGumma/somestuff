package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParantheses {
	
	public List<String> removeInvalidParentheses(String s) {
		List<String> ret = new ArrayList<String>();
		if (s == null) return ret;
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.add(s);
		visited.add(s);
		
		while(!q.isEmpty()) {
			String target = q.poll();
			if (isValidParantheses(target)) {
				ret.add(target);
				continue;
			}
			for (int i = 0; i < target.length(); i++) {
				if (target.charAt(i) == '(' || target.charAt(i) == ')') {
					String newstring = target.substring(i+1) + target.substring(0, i);
					if (!visited.contains(newstring)) {
						q.add(newstring);
						visited.add(newstring);
					}
				}
			}
		}
		return ret;
	 }
	
	private boolean isValidParantheses(String t)
	{
		int count = 0;
		char []tchars = t.toCharArray();
		for (int i = 0; i < tchars.length; i++) {
			if (tchars[i] == '(') count++;
			if (tchars[i] == ')' && count-- == 0) return false;
		}
		return count == 0;
	}
}
