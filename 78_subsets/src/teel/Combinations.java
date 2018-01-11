package teel;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
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
	
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> l = new ArrayList<Integer>(n);
		for (int i = 1 ; i <= n; i++) {
        	l.add(i);
        }
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> excluded = new ArrayList<Integer>();
		List<Integer> untilNow = new ArrayList<Integer>();
		foo(l, 0, excluded, k, untilNow, ret);
		for (List<Integer> li : ret) {
			System.out.print("[");
			for (Integer i : li) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("]");
		}
		System.out.println("Size is " + ret.size());
		return ret;
    }
	
	public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<Integer>(nums.length);
        for (int i = 0 ; i < nums.length; i++) {
        	l.add(nums[i]);
        }
        return bar(l);
    }
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		c.combine(10, 5);
	}
}
