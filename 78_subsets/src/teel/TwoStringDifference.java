package teel;

public class TwoStringDifference {
	public char findTheDifference(String s, String t) {
		int []diff = new int [8];
		char ret;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < t.length(); j++) {
				int num = (t.charAt(j) - '0');
				diff[i] += ( num >>i) & 1;
			}
			
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < s.length(); j++) {
				diff[i] -= ((s.charAt(j) - '0') >>i) & 1;
			}
		}
		int num = 0;
		for (int i =0; i < 8; i++) {
			num += diff[i]*(Math.pow(2, i));
		}
		ret = (char)(num + '0');
		return ret;
    }
	
	public static void main(String []args)
	{
		TwoStringDifference tsd = new TwoStringDifference();
		System.out.println(tsd.findTheDifference("keertiaaabbc", "aaabbcckeerti"));
	}
}
