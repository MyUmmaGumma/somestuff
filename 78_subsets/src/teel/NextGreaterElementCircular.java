package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementCircular {
	class IntPos {
		public int val;
		public int pos;
		IntPos(int _val, int _pos) {
			val = _val;
			pos = _pos;
		}
	}
	
	public int[] nextGreaterElements(int []nums) {
		int []newints = new int[nums.length];
		Arrays.fill(newints, -1);
		if (nums == null || nums.length == 0 ) {
			return newints;
		}
		
		int []newarr = new int[nums.length * 2];
		int i = 0;
		for(int j = 0; j < newarr.length; j = j+nums.length) {
			for (i = 0; i < nums.length; i++) {
				newarr[i+j] = nums[i]; 
			}
		}
		
	
		Stack<IntPos> s = new Stack<IntPos>();
		
		s.push(new IntPos(nums[0], 0));
		//Identify Decreasing subsequence
		for ( i = 1; i < newarr.length; i++) {
			// If a greater number is encountered, pop stack until top of stack is greater
			while (!s.isEmpty() && (s.peek().val < newarr[i])) {
				IntPos ip = s.peek();
				newints[ip.pos] = newarr[i];
				s.pop();
			}
			// Until you encounter a greater number, add to stack. Don't exceed original array size
			if (i < nums.length) {
				s.push(new IntPos(newarr[i], i));
			}
		}
		return newints;
    }
	
	public static void main(String []args)
	{
		
		int q[] = {100,1,11,1,120,111,123,1,-1,-100};
		NextGreaterElementCircular nge = new NextGreaterElementCircular();
		int []res = nge.nextGreaterElements(q);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
