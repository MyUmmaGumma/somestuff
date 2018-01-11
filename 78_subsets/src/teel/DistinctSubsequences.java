package teel;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int slen = s.length()+1;
		int tlen = t.length() + 1;
		if (slen < tlen) {
			return 0;
		}
		int [][]M = new int[tlen][slen];
		for(int i = 0; i < tlen; i++) {
			for (int j = 0; j < slen; j++) {
				M[i][j] = 0;
			}
		}
		for (int i = 0; i < t.length();i++) {
			for (int j = 0; j < s.length();j++) {
				char c = s.charAt(j);
				char d = t.charAt(i);
				if (c == d) {
					if (i == j) {
						if (i == 0)
							M[i+1][j+1] = 1;
						else 
							M[i+1][j+1] = M[i][j];
					} else 
					if (M[i][j+1] == 0) {
						M[i+1][j+1] = M[i+1][j] + 1;
					} else {
						if (i > 0 && M[i][j] == 0) {
							M[i+1][j+1] = 0;
						} else {
							M[i+1][j+1] = M[i][j] + M[i+1][j];
						}
					}
				} else {
					M[i+1][j+1] = M[i+1][j];
				}
			}
		}
		return M[tlen-1][slen-1];
    }
	
	public static void main(String []args)
	{
		DistinctSubsequences ds = new DistinctSubsequences();
		int s = ds.numDistinct("eee", "eee"
				+ "");
		System.out.println(s);
	}
}
