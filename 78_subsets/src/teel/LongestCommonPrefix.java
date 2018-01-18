package teel;

public class LongestCommonPrefix {
	public String longest(String []strs) {
		int len = 1, lcf = 0, temp = 1;
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		do {
			boolean no_common_len = false;
			for(int i = 0; i < strs.length; i++) {
				if (strs[i].length() < len) {
					no_common_len = true;
				}
			}
			if (no_common_len) {
				break;
			}
			String prefix = strs[0].substring(0, len);
			boolean nomatch = false;
			for(int i = 1; i < strs.length; i++) {
				if (!strs[i].startsWith(prefix)) {
					nomatch = true;
					break;
				}
			}
			if (nomatch) {
				break;
			} 
			lcf++;
			len++;
		} while(len > 0);
		return strs[0].substring(0, lcf);
	}
	
	public static void main(String []args)
	{
		LongestCommonPrefix lcf = new LongestCommonPrefix();
		/* String []arr = {"testosterone", "test", "tests","testicles","testes"};
		String s = lcf.longest(arr);
		System.out.println(s); */
		String []arr1 = {"aa","ab"};
		String s1 = lcf.longest(arr1);
		System.out.println(s1);
	}
}
