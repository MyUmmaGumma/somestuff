package teel;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int i = 0, j = s.length() - 1, start = 0;
		StringBuilder sb = new StringBuilder();
		boolean matchFirst = false;
		sb.append(s);
		while (i <= s.length()/2 && j >=0 && i < j ) {
			if  (s.charAt(i) == s.charAt(j)) {
				if (i == 0) {
					matchFirst = true;
				}
				i++; j--;
			} else {
				if (matchFirst) {
					String sub = s.substring(j);
					String revsub = new StringBuffer(sub).reverse().toString();
					sb.insert(start, revsub);
					matchFirst = false;
					start = s.length() - j - 1;
					j--;
				} else {
					sb.insert(start, s.charAt(j));
					j--; start++;
				}
			}
		}
		return sb.toString();
    }
	
	public static void main(String []args)
	{
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("abcd"));
		System.out.println(sp.shortestPalindrome("aabba"));
		System.out.println(sp.shortestPalindrome("aacecaaa"));
		
	}
}