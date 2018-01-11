
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        List<Integer> lprev = null;
        for(int i = 0; i < numRows; i++) {
        	List<Integer> li = new ArrayList<Integer>();
        	li.add(1);
        	li.add(1);
        	for (int j = i+1; i < numRows-1;j++) {
        		int e = li.get(j-1)+li.get(j); 
        		li.add(e);
        	}
        	lli.add(li);
        	lprev = li;
        }
        return lli;
    }
	
	public static void main()
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
