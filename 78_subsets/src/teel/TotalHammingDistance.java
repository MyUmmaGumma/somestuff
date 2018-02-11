package teel;

public class TotalHammingDistance {
	public int totalHammingDistance(int []arr)
	{
		int count = 0, res = 0;
		for (int j = 0; j < 32; j++) {
			for (int i = 0; i < arr.length; i++) {
				//Count number of array elements that have their jth bit set
				count += (arr[i] >>j) & 1;
			}
			// If among n numbers, count number of elements have their bit set
			// (n-count) don't have that bit set, so that contributes to
			// count X (n - count) towards the hamming distance
			res += count * (arr.length - count);
		}
		return res;
	}
}
