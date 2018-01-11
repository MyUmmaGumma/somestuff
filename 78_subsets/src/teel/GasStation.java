package teel;

public class GasStation {
	public int iterate(int []gas, int []cost, int i)
	{
		if (gas[i] >= cost[i]) {
			int remain = gas[i] - cost[i];
			int count = 1, j = i;
			while (count < gas.length) {
				j = (j + 1) % gas.length;
				if (gas[j] + remain < cost[j]) {
					return -1;
				} 
				remain += gas[j] - cost[j];
				count++;
			}
			return 1;
		}
		return -1;
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i = 0; i < gas.length; i++) {
			if (iterate(gas, cost, i) != -1) {
				return i;
			}
		}
		return -1;
    }
	
	public static void main(String []args)
	{
		GasStation gs = new GasStation();
		int []gas = {1,2,3,4,5};
		int []cost = {3,4,5,1,2};
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}
	
	
}
