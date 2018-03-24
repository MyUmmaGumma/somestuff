package teel;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s.length() == 0) return 0;
		
		int []memo = new int [s.length() + 1];
		memo[0] = 0;
		if (s.charAt(0) == '0') {
			memo[1] = 0;
		} else {
			memo[1] = 1;
		}
		
		if (s.length() == 1) return memo[1];
		if(s.charAt(1) != '0') {
            memo[2] = memo[1];
        }
		
		int val = Integer.parseInt(s.substring(0,2));
		if (val >= 10 && val <= 26 ) {
			memo[2] = memo[2] + 1;
		} 
		
		for (int i = 3; i <= s.length(); i++) {
			if (s.charAt(i-1) != '0') {
				memo[i] = memo[i-1];
			}
			
			val = Integer.parseInt(s.substring(i-2,i));
			if (val >= 10 && val <= 26) {
				memo[i] = memo[i-2] + memo[i];
			}
		}
		return memo[s.length()];
    }
}
