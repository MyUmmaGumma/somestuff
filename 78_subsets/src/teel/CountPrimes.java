package teel;

public class CountPrimes {
	public int countPrimes(int n) {
		//Implement sieve of Erasthones
		if (n ==0 || n== 1) return 0;
		if (n == 2) return 1;
		if (n == 3) return 1;
		
		int count = 0;
		boolean array[] = new boolean[n];
		
		for (int i = 2; i < array.length; i++) {
			array[i] = true;
		}
		for (int i = 2; i < array.length; i++) {
			if (array[i]) {
				for ( int j = 2; i*j < array.length; j++) {
					array[i*j] = false;
				}
			}
		}
		for (int i = 2; i < array.length; i++) {
			if (array[i] == true) {
				System.out.println(i);
				count++;
			}
		}
		return count;
    }
	
	public static void main(String []args)
	{
		CountPrimes cp = new CountPrimes();
		System.out.println("Count = " + cp.countPrimes(499979));
	}
}
