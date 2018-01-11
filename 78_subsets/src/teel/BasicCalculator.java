package teel;

import java.util.LinkedList;

public class BasicCalculator {
	public int calculate(String s) {
		LinkedList<Character> lt = new LinkedList<Character>();
		int start = 0;
		boolean pop2 = false;
		for (int i=start;i<s.length();i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			if (Character.isDigit(s.charAt(i))) {
				Character d = s.charAt(i);
				if (pop2 == false) {
					lt.push(d);
				} else {
					Character operator = lt.removeFirst();
					Character operand2 = lt.removeFirst();
					//System.out.println("Operating on " + d + " op: " + operator + " and " + operand2);
					if (operator == '+') {
						int val = (d - '0') + (operand2 - '0') ;
						lt.add((char) (val + '0'));
					} else if (operator == '-') {
						int val = (operand2 - '0') - (d - '0') ;
						lt.add((char) (val + '0'));
					}
					pop2 = false;
				}
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				lt.push(s.charAt(i));
				pop2 = true;
			}
		}
		return lt.removeFirst() - '0';
	}
	
	public int calculateS(String s) {
		LinkedList<Integer> lt = new LinkedList<Integer>();
		int start = 0;
		Integer syn = 0;
		LinkedList<Character> ltc = new LinkedList<Character>();
		boolean pop2 = false, wasNumber = false;
		for (int i=start;i<s.length();i++) {
			if (s.charAt(i) == ' ') {
				if (wasNumber) {
					lt.push(syn);
					wasNumber = false;
				}
				continue;
			}
			if (Character.isDigit(s.charAt(i))) {
				int d = s.charAt(i) - '0';
				syn  = (syn*10) + d;
				if (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
					continue;
				}
				if (pop2 == false) {
					wasNumber = true;
				} else {
					Character operator = ltc.removeFirst();
					Integer operand2 = lt.removeFirst();
					
					if (operator == '+') {
						Integer val = operand2 + syn ;
						lt.add(val);
					} else if (operator == '-') {
						Integer val = operand2 - syn;
						lt.add(val);
					}
					pop2 = false;
				}
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (wasNumber) {
					lt.push(syn);
					wasNumber = false;
					
				}
				ltc.push(s.charAt(i));
				pop2 = true;
				syn = 0;
			} else if (s.charAt(i) == '(') {
				pop2 = false;
				syn = 0;
			} else if (s.charAt(i) == ')') {
				pop2 = true;
			}
		}
		if (lt.isEmpty()) {
			return syn;
		}
		while (ltc.isEmpty() == false) {
			Character operator = ltc.removeFirst();
			Integer operand2 = lt.removeFirst();
			Integer operand1 = 0;
			if (lt.isEmpty()) {
				operand1 = syn;
			} else {
				operand1 = lt.removeFirst();
			}
			
			if (operator == '+') {
				Integer val = operand2 + operand1 ;
				lt.add(val);
			} else if (operator == '-') {
				Integer val = operand2 - operand1;
				lt.add(val);
			}
			pop2 = false;
		}
		return lt.removeFirst();
	}
	
	
	public static void main(String []args)
	{
		BasicCalculator bc = new BasicCalculator();
		String s5 = "1 - (5)";
		System.out.println(s5 + " = " + bc.calculateS(s5));
		String s4 = "2 - ( 5 - 6 )";
		System.out.println(s4 + " = " + bc.calculateS(s4));
		String s3 = "1 - 11";
		System.out.println(s3 + " = " + bc.calculateS(s3));
		String s = " 2-1 + 2 ";
		System.out.println(s + " = " + bc.calculateS(s));
		String s1 = "1 + 1";
		System.out.println(s1 + " = " + bc.calculateS(s1)); 
		String s2 = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(s2 + " = " + bc.calculateS(s2));
		
	}
}
