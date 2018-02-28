package teel;

public class ClimbingStairsMinCost {
	 private void minCostClimbingStairs_int(int[] cost, int []memo) {
		 
	 }
	 
	 public int minCostClimbingStairs(int[] cost) {
		 int []memo = new int[cost.length+1];
		 memo[0] = 0;
		 memo[1] = 0;
		 for (int i = 2; i <= cost.length; i++) {
			 memo[i] = Math.min(memo[i-2] + cost[i-2], memo[i-1] + cost[i-1]);
		 }
		 return memo[cost.length];
	 }
	 
	 public static void main (String []args)
	 {
		 ClimbingStairsMinCost csmc = new ClimbingStairsMinCost();
		 int []cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		 
		 System.out.println(csmc.minCostClimbingStairs(cost));
	 }
}
