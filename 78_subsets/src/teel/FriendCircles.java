package teel;

import java.util.Arrays;

public class FriendCircles {
	
	public int findCircleNum(int[][] M) {
		class UF
		{
			int []arr = null;
			UF(int n){
				arr = new int [n];
				Arrays.fill(arr,-1);
			}
			
			public int FindRoot(int i)
			{
				if (arr[i] == -1) {
					return i;
				} else {
					while (arr[i] != -1) {
						i = arr[i];
					}
					return i;
				}
			}
			
			public void Union(int i, int j)
			{
				if (i == j) {
					return;
				}
				int a = FindRoot(i);
				int b = FindRoot(j);
				if (a != b) {
					arr[a] = b;
				}
			}
			
			public int findSets()
			{
				int count = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == -1) {
						count++;
					}
				}
				return count;
			}
		}
		
		UF uf = new UF(M.length);
		for (int i = 0 ; i < M.length; i++) {
			for ( int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 1) {
					uf.Union(i, j);
				}
			}
		}
		return uf.findSets();
    }
	
	public static void main(String []args)
	{
		FriendCircles fc = new FriendCircles();
		int [][]M = {{1,1,0}, {1,1,0}, {0,0,1}};
		System.out.println(fc.findCircleNum(M));
	}
}
