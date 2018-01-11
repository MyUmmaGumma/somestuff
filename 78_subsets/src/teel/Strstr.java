package teel;

public class Strstr {
	public int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length()) return -1;
		for (int i = 0; i < haystack.length(); i++) {
			int j = 0;
			for (j = 0; j < needle.length(); j++) {
				if (i + j >= haystack.length()) break;
				if (haystack.charAt(i+j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
    }
	
	public static void main(String []args)
	{
		Strstr ss = new Strstr();
		System.out.println(ss.strStr("This is bullshit", "This"));
		System.out.println(ss.strStr("This is bullshit", "is"));
		System.out.println(ss.strStr("This is bullshit", "shit"));
		System.out.println(ss.strStr("This is bullshit", "isis"));
		System.out.println(ss.strStr("This is bullshit", "  "));
		System.out.println(ss.strStr("This ", "is "));
		System.out.println(ss.strStr("This is bullshit", "is b"));
		System.out.println(ss.strStr("Mississippi", "ippissi"));
	}
}
