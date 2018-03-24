package teel;

public class GlobalLocalInversion {
	int local;
	int global;
	
	private int[] count_inv(int []a, int []b, int low, int high, int mid)
	{
		int []newarr = new int[high - low + 1];
		for (int i = low, j =mid+1; i <= mid && j <= high;) {
			if (a[i] > b[j] && j == i+1) {
				local++;
			} else if (a[i] > b[j]) {
				newarr[i] = b[j];
				j++;
				global += (j-i);
			} else {
				newarr[i] = a[i];
				i++;
			}
		} 
		
		return newarr;
	}
	
	private int[] merge(int []a, int low, int high)
	{
		if (low >= high) {
			return a;
		}
		int mid = low + (low + high)/2;
		int []resa = merge(a, low, mid);
		int []resb = merge(a, mid + 1, high);
		return count_inv(resa, resb, low, high, mid);
	}
	
	public boolean isIdealPermutation(int[] A) {
        if (A.length <= 1) {
        		return true;
        }
        local = global = 0;
        merge(A, 0, A.length-1);
        return (local == global);
    }
}
