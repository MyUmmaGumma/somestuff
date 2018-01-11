package teel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Parantheses {
	String valid1 = "()";
	
	private List<String> gen(int n)
	{
		//just add () to every position of every String of previously generated set of valid parantheses
		List<String> ls = new ArrayList<String>();
		HashSet<String> hs = new HashSet<String>();
		HashSet<String> templs = new HashSet<String>();
		templs.add(valid1);
		for (int i = 1; i < n; i++)
        {
        	for (String s : templs) {	
        		for (int j = 0; j < s.length()+1; j++) {
        			String first = s.substring(0, j);
        			if (!first.isEmpty()) {
        				hs.add(first + valid1+s.substring(j));
        			} else {
        				hs.add(valid1+s.substring(j));
        			}
        		}
        	}
        	templs.clear();
        	templs.addAll(hs);
        	hs.clear();
        }
		
		ls.addAll(templs);
		return ls;
	}
	
	public boolean isValid(String s) {
		Stack<Character> sc = new Stack<Character>();
		for (int i = 0; i < s.length();i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				sc.push(c);
			} else {
				if (sc.isEmpty()) {
					return false;
				}
				char expected = sc.peek();
				if (c == ')') {
					if (expected != '(') {
						return false;
					}
				}
				if (c == '}') {
					if (expected != '{') {
						return false;
					}
				}
				if (c == ']') {
					if (expected != '[') {
						return false;
					}
				}
				sc.pop();
			}
		}
		if (sc.isEmpty()) { 
			return true;
		}
		return false;
    }
	
	public List<String> generateParenthesis(int n) {
		List<String> ls = new ArrayList<String>();
		if (n == 0) {
			return ls;
		}
		ls.add(valid1);
		if (n == 1) {			
			return ls;
		}
        return gen(n); 
    }
	
	public int longestValidParentheses(String s) {
		Stack<Integer> sc = new Stack<Integer>();
		int current=0, max = 0;
		for (int i = 0; i < s.length();i++) {
			char c = s.charAt(i);
			if (c == '(') {
				sc.push(current);
				if (max < current) {
					max = current;
				}
				current = 0;
			} else {
				if (sc.isEmpty()) {
					if (max < current) {
						max = current;
						current = 0;
					}
				} else {
					current += sc.pop()+1;
				}
			}
		}
		if (max < current) {
			max = current;
		}
		return max;
    }
	
	public static void main(String []args)
	{
		Parantheses p = new Parantheses();
		List<String> ls = p.generateParenthesis(2);
		for (String s : ls) {
			System.out.println(s);
		}
		System.out.println("([)] is " + p.isValid("([)]"));
		System.out.println("()[]{} is " + p.isValid("()[]{}"));
		System.out.println("(] is " + p.isValid("(]"));
		System.out.println("( is " + p.isValid("("));
		System.out.println("()()) longest is " + p.longestValidParentheses("()())"));
		System.out.println("()(() longest is " + p.longestValidParentheses("()(()"));
		System.out.println("()(()) longest is " + p.longestValidParentheses("()(())"));
		System.out.println("()((()()) longest is " + p.longestValidParentheses("()((()())"));
		System.out.println("()((()()) longest is " + p.longestValidParentheses("()(()())"));
		System.out.println(")(((((()())()()))()(()))( longest is " + p.longestValidParentheses(")(((((()())()()))()(()))("));;
	}
}
