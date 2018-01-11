package teel;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class NextGreaterElement {
	
	
	public int[] nextGreaterElements(int[] findnums, int []nums) {
		int []newints = new int[findnums.length];
		if (nums == null || nums.length == 0 || findnums.length == 0) {
			return newints;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		HashMap<Integer, Integer> hmi = new HashMap<Integer, Integer>();
		s.push(nums[0]);
		//Identify Decreasing subsequence
		for (int i = 0; i < nums.length; i++) {
			while (!s.isEmpty() && s.peek() < nums[i]) {
				hmi.put(s.peek(), nums[i]);
				s.pop();
			}
			s.push(nums[i]);
		}
		
		for (int i = 0; i < findnums.length; i++) {
			if (hmi.containsKey(findnums[i])) {
				newints[i] = hmi.get(findnums[i]);
			} else {
				newints[i] = -1;
			}
		}
		return newints;
    }
	
	public static void main(String []args)
	{
		int p[] = {2,4};
		int q[] = {1,2,3,4};
		NextGreaterElement nge = new NextGreaterElement();
		int []res = nge.nextGreaterElements(p, q);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
