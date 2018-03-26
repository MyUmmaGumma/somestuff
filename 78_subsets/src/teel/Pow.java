package teel;

public class Pow {
	//Pow(x, n)
	
	private double pow_int(double x, long n)
	{
		if (n == 0) {
			return 1.0;
		} 
		double nby2 = pow_int(x, n/2);
		if (n % 2 == 1) {
			return nby2 * nby2 * x;
		} else {
			return nby2 * nby2;
		}
	}
	
	public double myPow(double x, int n) {
		long N = n;
        if (n < 0) {
        		N = -N;
        		x = 1/x;
        }
        return pow_int(x, N); 
    }
}
