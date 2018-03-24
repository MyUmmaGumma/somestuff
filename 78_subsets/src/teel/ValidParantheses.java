package teel;

import java.util.Stack;

public class ValidParantheses {
	Stack<Character> curly;
	Stack<Character> sq;
	Stack<Character> reg;
	
	public boolean isValid(String s) {
	/*	curly = new Stack<>();
		sq = new Stack<>();
		reg = new Stack<>();
		char []c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] =='(') {
				reg.push('(');
			} else if (c[i] =='{') {
				curly.push('(');
			} else if (c[i] =='[') {
				sq.push('[');
			} else if (c[i] ==')') {
				if (reg.isEmpty()) {
					return false;
				}
				reg.pop();
			} else if (c[i] =='}') {
				if (curly.isEmpty()) {
					return false;
				}
				curly.pop();
			} else {
				if (sq.isEmpty()) {
					return false;
				}
				sq.pop();
			}
		}
		if (sq.isEmpty() && curly.isEmpty() && reg.isEmpty())
			return true;
		return false;
		*/
		curly = new Stack<>();
		char []c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] =='(' || c[i] =='[' || c[i] =='{') {
				curly.push(c[i]);
			}
			if (c[i] =='}' || c[i] ==']' || c[i] ==')') {
				if (curly.isEmpty()) 
					return false;
				else if (c[i] == ')' && curly.peek() != '(') 
					return false;
				else if (c[i] == '}' && curly.peek() != '{') 
					return false;
				else if (c[i] == ']' && curly.peek() != '[')
					return false;
				curly.pop();
			}
		}
		if (!curly.isEmpty()) return false;
		return true;
    }
}
