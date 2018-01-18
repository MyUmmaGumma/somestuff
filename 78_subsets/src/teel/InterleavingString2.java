package teel;

public class InterleavingString2 {
	private boolean isInterleave_int(String s1, String s2, String s3)
	{
		int i = 0, j = 0;
		System.out.println("Matching s1 = " + s1 + " s2 = " + s2 + " s3 = " + s3);
		for(int k = 0; k < s3.length() ; k++) {
			if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
				
				boolean res = isInterleave_int(s1.substring(1), s2, s3.substring(1));
				if (res == true) {
					return true;
				}
			} 
			if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
				System.out.println();
				boolean res = isInterleave_int(s1, s2.substring(1), s3.substring(1));
				if (res == true) {
					return true;
				}
			} 
		}
		return false;
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s2.length() + s1.length()) {
			return false;
		} 
		StringBuilder s4 = new StringBuilder();
		s4.append(s1);
		s4.append(s2);
		if (s3.contentEquals(s4)) {
			return true;
		}
		
		StringBuilder s5 = new StringBuilder();
		s5.append(s2);
		s5.append(s1);
		if (s3.contentEquals(s5)) {
			return true;
		}
		return isInterleave_int(s1, s2, s3);
    }
	
	public static void main(String []args)
	{
		InterleavingString2 is = new InterleavingString2();
		/* System.out.println(is.isInterleave("aaa", "bbb", "aabbba"));
		System.out.println(is.isInterleave("aaa", "bbb", "aabbca"));
		System.out.println(is.isInterleave("aaa", "bbb", "abbbba"));
		System.out.println(is.isInterleave("aaa", "bbb", "aabbaa"));
		System.out.println(is.isInterleave("aaa", "bbb", "aaabbb"));
		System.out.println(is.isInterleave("aaa", "bbb", "bbbaaa"));
		System.out.println(is.isInterleave("aaa", "bbb", "baaabb"));
		System.out.println("-----------------------------");
		System.out.println(is.isInterleave("a", "b", "ba"));
		System.out.println(is.isInterleave("a", "b", "bb"));
		System.out.println(is.isInterleave("a", "b", "aa"));
		System.out.println(is.isInterleave("a", "b", "ab"));
		System.out.println("-----------------------------"); 
		System.out.println(is.isInterleave("aabcc", "dbbca","aadbbcbcac"));
		System.out.println(is.isInterleave("aabcc", "dbbca","aadbbbaccc")); 
		System.out.println(is.isInterleave("aabc", "abad", "aabacbad"));*/
		
		System.out.println(is.isInterleave("aabcc", "dbbca", "aadbcbbcac"));
	}
}
