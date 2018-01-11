package teel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FunctionalInterfaces {
	public void experiment(int num1)
	{
		int totalSum = num1;
		
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
				if (cond.test(li, totalSum)) {
					ret.add(li);
				}
			}
			return ret;
		};
	}
}
