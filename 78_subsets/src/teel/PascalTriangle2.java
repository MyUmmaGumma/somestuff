package teel;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
	public List<Integer> generate(int rowIndex) {
        
        if (rowIndex == 0) {
        	List<Integer> li = new ArrayList<Integer>();
        	li.add(1);
        	return li;
        }
        if (rowIndex == 1) {
        	List<Integer> li = new ArrayList<Integer>();
        	li.add(1);li.add(1);
        	return li;
        } 
        List<Integer> li = new ArrayList<Integer>();
    	li.add(1);li.add(1);
    	
    	
        List<Integer> lprev = li;
        for(int i = 1; i <= rowIndex; i++) {
        	li = new ArrayList<Integer>();
        	li.add(1);
        	for (int j = 1; j < i;j++) {
        		int e = lprev.get(j-1)+lprev.get(j); 
        		li.add(e);
        	}
        	li.add(1);        	
        	lprev = li;
        }
        return li;
	}
	
	public static void main(String []args)
	{
		PascalTriangle2 pt = new PascalTriangle2();
		List<Integer> li = pt.generate(2);
		
		for (Integer i : li) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
