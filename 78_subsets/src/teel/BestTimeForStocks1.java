package teel;

public class BestTimeForStocks1 {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, currProfit = Integer.MIN_VALUE;
		int maxAfterMin = Integer.MIN_VALUE;
		if (prices.length <= 1) return 0;
		
		for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
				maxAfterMin = 0;
				continue;
			}
			if (maxAfterMin < prices[i]) {
				maxAfterMin = prices[i];
				if (currProfit < (maxAfterMin - min))
					currProfit = maxAfterMin - min;
			}
		}
		return (maxAfterMin == 0 && currProfit == Integer.MIN_VALUE) ? 0 : currProfit;
    }
	
	public static void main(String []args)
	{
		BestTimeForStocks1 bs1 = new BestTimeForStocks1();
		/*int []prices = {7,1,5,3,6,4};
		System.out.println(bs1.maxProfit(prices));
		int []prices1 = {7,6,4,3,1};;
		System.out.println(bs1.maxProfit(prices1));
		int []prices2 = {7,6,4,3,1,2,1,1,3,4,1,2};;
		System.out.println(bs1.maxProfit(prices2));
		int []prices3 = {3,1,2,4,1,3,4,0,2};;
		System.out.println(bs1.maxProfit(prices3));*/
		int []prices4 = {2,4,1};;
		System.out.println(bs1.maxProfit(prices4));
	}
}
