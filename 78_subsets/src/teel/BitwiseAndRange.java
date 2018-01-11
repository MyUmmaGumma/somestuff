package teel;

public class BitwiseAndRange {
	public int rangeBitwiseAnd(int m, int n) {
		//Implement the common left header
		int c = 0;
		while ( m != n) {
			m >>= 1;
			n >>= 1;
			c++;
		}
		return n<<c;
    }
}
