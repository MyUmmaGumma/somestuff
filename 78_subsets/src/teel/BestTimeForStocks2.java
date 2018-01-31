package teel;

public class BestTimeForStocks2 {
	public int maxProfit(int[] prices) {
		int currProfit = 0;
		
		if (prices.length <= 1) return 0;
		
		for(int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				currProfit += prices[i] - prices[i-1];
			}
		}
		
		return currProfit;
    }
	
	public static void main(String []args)
	{
		BestTimeForStocks2 bs2 = new BestTimeForStocks2();
		/*int []prices = {7,1,5,3,6,4};
		System.out.println(bs1.maxProfit(prices));
		int []prices1 = {7,6,4,3,1};;
		System.out.println(bs1.maxProfit(prices1));
		int []prices2 = {7,6,4,3,1,2,1,1,3,4,1,2};;
		System.out.println(bs1.maxProfit(prices2));
		int []prices3 = {3,1,2,4,1,3,4,0,2};;
		System.out.println(bs1.maxProfit(prices3));*/
		int []prices4 = {7,1,5,7,8,11,13};;
		System.out.println(bs2.maxProfit(prices4));
	}
}
