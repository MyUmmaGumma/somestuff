package teel;

public class RotateFunction {
	public int maxRotateFunction(int[] A) {
		int bksum = 0, ret = 0, len = A.length, max = 0;
		for (int i = 0; i < A.length; i++) {
			bksum += A[i];
			ret += i*A[i];
		}
		max = ret;
		for (int i = len - 1; i >= 1; i--) {
			ret += bksum + len*A[i];
			max = Math.max(max, ret);
		}
		return ret;
    }
}
