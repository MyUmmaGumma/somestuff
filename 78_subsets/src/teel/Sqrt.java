package teel;

public class Sqrt {
	private int binsearch(int x)
	{
		if (x == 0) return 0;
		int low = 1, high = x, mid = 0;
		while (low < high) {
			mid = low + (high - low)/2;
			if ((x/mid >= mid ) && x / (mid+1) < (mid+1)) {
				break;
			}
			if (x/mid < mid) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}
	public int mySqrt(int x) {
		return binsearch(x);
	}
}
