package teel;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        if (numRows == 0) {
        	return lli;
        }
        if (numRows == 1) {
        	List<Integer> li = new ArrayList<Integer>();
        	li.add(1);
        	lli.add(li);
        	return lli;
        }
        if (numRows == 2) {
        	List<Integer> li = new ArrayList<Integer>();
        	li.add(1);
        	lli.add(li);
        	li = new ArrayList<Integer>();
        	li.add(1);li.add(1);
        	lli.add(li);
        	return lli;
        } 
        List<Integer> li = new ArrayList<Integer>();
    	li.add(1);
    	lli.add(li);
    	li = new ArrayList<Integer>();
    	li.add(1);li.add(1);
    	lli.add(li);
    	
        List<Integer> lprev = li;
        for(int i = 2; i < numRows; i++) {
        	li = new ArrayList<Integer>();
        	li.add(1);
        	for (int j = 1; j < i;j++) {
        		int e = lprev.get(j-1)+lprev.get(j); 
        		li.add(e);
        	}
        	li.add(1);
        	lli.add(li);
        	lprev = li;
        }
        return lli;
    }
	
	public static void main(String []args)
	{
		PascalTriangle pt = new PascalTriangle();
		List<List<Integer>> lli = pt.generate(5);
		for (List<Integer> li : lli) {
			for (Integer i : li) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
