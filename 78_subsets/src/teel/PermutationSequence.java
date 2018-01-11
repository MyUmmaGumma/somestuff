package teel;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	
	public int next(int [][]validPerPosition, int pos)
	{
		for (int i = 0; i < validPerPosition.length; i++) {
			if (validPerPosition[pos][i] != -1) {
				validPerPosition[pos][i] = -1;
				return i;
			}
		}
		return -1;
	}
	
	private void foo(int i, int []nums, String seed, List<String> valids, int [][]validPerPosition)
	{
		int c = next(validPerPosition, i) ;
		String s="";
		while (c != -1) {
			s = new String(seed);
			s += c;
			if (s.length() == nums.length) {
				break;
			}
			foo(i, nums, s, valids, validPerPosition);
		}
		if (!s.isEmpty()) {
			valids.add(s);
		}
	}
	
	public List<String> bar(int []nums, int k, int [][]validPerPosition)
	{
		List<String> ls = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			String s = new String();
			foo(i, nums, s, ls, validPerPosition);
		}
		return ls;
	}
	
	public String getPermutation(int n, int k) {
		int []nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		int [][]validPerPosition = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				validPerPosition[i][j] = 0;
			}
		}
		bar(nums, k, validPerPosition);
		return "";
    }
	
	public static void main(String []args)
	{
		PermutationSequence ps = new PermutationSequence();
		ps.getPermutation(3,2);
	}
}
