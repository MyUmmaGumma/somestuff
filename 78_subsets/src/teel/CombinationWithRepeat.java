package teel;

import java.util.List;
import java.util.ArrayList;

public class CombinationWithRepeat {
	private void
	foo(List<Integer> candidates, int index, int choice,
			List<Integer> untilNow, List<List<Integer>> subsets)
	{
		if (choice == 1) {
			for (int i = index; i < candidates.size(); i++) {
				int c = candidates.get(i);
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(c);
				if (!subsets.contains(temp)) {
					subsets.add(temp);
				}
			}
			return;
		} else {
			/* if (candidates.size() - index == choice) {
				List<Integer> li = new ArrayList<Integer>(candidates);
				subsets.add(li);
				return;
			} */
			for (int i = index; i < candidates.size(); i++) {
				int c = candidates.get(i);
				untilNow.add(c);
				List<List<Integer>> temp_subsets = new ArrayList<List<Integer>>();
				foo(candidates, i+1, choice - 1, untilNow, temp_subsets);					
				for (List<Integer> li : temp_subsets) {
					/*for (Integer seen : untilNow) {
						li.add(li.size()-1, seen);
					}*/
					li.add(c);
				}
				for (List<Integer> li : temp_subsets) {
					subsets.add(li);
				}
				//untilNow = new ArrayList<Integer>();
				untilNow.remove(new Integer(c));
				
			}
		}
	}
	
	public List<List<Integer>> combos(List<Integer> orig)
	{
		List<List<Integer>> masterListReturn = new ArrayList<List<Integer>>();
		for (int i = 1; i <= orig.size(); i++) {
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			List<Integer> candidates = new ArrayList<Integer>();
			candidates.addAll(orig);
			List<Integer> untilNow = new ArrayList<Integer>();
			foo(candidates, 0, i, untilNow, ret);
			for (List<Integer> l : ret) {
				if (!masterListReturn.contains(l))
				masterListReturn.add(l);
			}
		}
		masterListReturn.add(new ArrayList<Integer>());
		
		 for (List<Integer> li : masterListReturn) {
			System.out.print("[");
			for (Integer i : li) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("]");
		}
		System.out.println("Size is " + masterListReturn.size()); 
		return masterListReturn;
		
	}
	
	public static void main(String []args)
	{
		int []arr={1,2,3,5,5,5,5};
		List<Integer> li = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		CombinationWithRepeat cwr = new CombinationWithRepeat();
		cwr.combos(li);
	}
}
