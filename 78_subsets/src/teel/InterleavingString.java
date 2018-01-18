package teel;

public class InterleavingString {
	private boolean isInterleave_int(String s1, String s2, String s3)
	{
		boolean founds1 = true, founds2 = false;
		int k = 0;
		
		for(int i = 0; i < s1.length(); i++) {
			
			if (s3.charAt(k) == s1.charAt(i)) {
				k++;
				int ik = k, j = 0;
				if (!founds2) {
					for (j = 0; j < s2.length() && ik < s3.length(); j++,ik++) {
						if (s3.charAt(ik) != s2.charAt(j)) {
							break;
						}
					}
					if (j == s2.length()) {
						founds2 = true;
						k += s2.length();
					}
				}
			} else {
				founds1 = false;
				break;
			}
		}
		return founds1 && founds2;
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
		return isInterleave_int(s1, s2, s3) || isInterleave_int(s2, s1, s3);
    }
	
	public static void main(String []args)
	{
		InterleavingString is = new InterleavingString();
		System.out.println(is.isInterleave("aaa", "bbb", "aabbba"));
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
		
	}
}
