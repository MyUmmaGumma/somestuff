package teel;

public class CustomSortString {
	 public String customSortString(String S, String T) {
		 char []c = new char [26];
		 for(char c1 : T.toCharArray()) {
			 c[c1 - 'a']++;
		 }
		 StringBuilder sb = new StringBuilder();
		 for (char c1 : S.toCharArray()) {
			 while (c[c1 - 'a'] > 0) {
				 c[c1 - 'a']--;
				 sb.append(c1);
			 }
		 }
		 for (char c1 = 'a'; c1 <= 'z'; c1++) {
			 while (c[c1 - 'a'] > 0) {
				 sb.append(c1); 
				 c[c1 - 'a']--;
			 }
		 }
		 return sb.toString();
	 }
}
