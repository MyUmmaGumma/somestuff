package teel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class CombinationSum {

	private void
	foo(List<Integer> candidates, int index, List<Integer> excluded, int choice, List<Integer> untilNow,
				List<List<Integer>> subsets)
	{
		if (choice == 1) {
			for (int i = index; i < candidates.size(); i++) {
				int c = candidates.get(i);
				if (!excluded.contains(c)) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(c);
					subsets.add(temp);
				}
			}
			return;
		} else {
			//for (int i = index; i < candidates.size() && (excluded.size() < choice); i++) {
			for (int i = index; i < candidates.size(); i++) {
				int c = candidates.get(i);
				untilNow.add(c);
				excluded.add(c);
				List<List<Integer>> temp_subsets = new ArrayList<List<Integer>>();
				foo(candidates, i+1, excluded, choice - 1, untilNow, temp_subsets);					
				for (List<Integer> li : temp_subsets) {
					for (Integer seen : untilNow) {
						if (!li.contains(seen)) {
							li.add(li.size()-1, seen);
						}
					}
				}
				for (List<Integer> li : temp_subsets) {
					subsets.add(li);
				}
				//untilNow = new ArrayList<Integer>();
				untilNow.remove(new Integer(c));
				excluded.remove(new Integer(c));
			}
		}
	}
	
	public List<List<Integer>>
	bar(List<Integer> orig)
	{
		List<List<Integer>> masterListReturn = new ArrayList<List<Integer>>();
		for (int i = 1; i <= orig.size(); i++) {
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			List<Integer> candidates = new ArrayList<Integer>();
			candidates.addAll(orig);
			List<Integer> excluded = new ArrayList<Integer>();
			List<Integer> untilNow = new ArrayList<Integer>();
			foo(candidates, 0, excluded, i, untilNow, ret);
			for (List<Integer> l : ret) {
				masterListReturn.add(l);
			}
		}
		masterListReturn.add(new ArrayList<Integer>());
		return masterListReturn;
		/* for (List<Integer> li : masterListReturn) {
			System.out.print("[");
			for (Integer i : li) {
				System.out.print(i);
				System.out.print(" ");	
			}
			System.out.println("]");
		}
		System.out.println("Size is " + masterListReturn.size()); */	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {2,3,6,7};
		
		CombinationSum s = new CombinationSum();
		List<List<Integer>> lli = s.combinationSum(nums, 7);
		for (List<Integer> li : lli) {
			System.out.print("[");
			for (Integer i : li) {
				System.out.print(i);
				System.out.print(" ");	
			}
			System.out.println("]");
		}
		System.out.println("Size is " + lli.size());
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<Integer> l = new ArrayList<Integer>(candidates.length);
        for (int i = 0 ; i < candidates.length; i++) {
        	l.add(candidates[i]);
        }
        List<List<Integer>> lli1 = bar(l);
        
		BiPredicate<List<Integer>, Integer> condition = (li, num) ->
			{
				int sum = 0;
				for(Integer i : li) {
					sum += i;
				}
				return (sum == num);
		
			};
			
		BiFunction<List<List<Integer>>, BiPredicate<List<Integer>, Integer>, List<List<Integer>>> bif = (lli, cond) ->
		{
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			for (List<Integer> li : lli) {
				if (cond.test(li, target)) {
					ret.add(li);
				}
			}
			return ret;
		};
		
		return bif.apply(lli1, condition);
    	
    }
	
}
