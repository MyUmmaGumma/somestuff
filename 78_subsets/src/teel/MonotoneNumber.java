package teel;

public class MonotoneNumber {
	
	 private void findMonotone(char []c, int start, StringBuilder sb)
	 {
		 if (sb.length() == 0 && c.length >= 1) {
			 sb.append(c[start]);
			 if (start + 1 < c.length) {
				 findMonotone(c, start+1, sb);
			 }
		 } else {
			 char ch = sb.charAt(0);
			 for (int i= 1; i < sb.length(); i++) {
				 if (ch > sb.charAt(i)) {
					 sb.delete(i, sb.length());
					 sb.append(ch - '1');
					 findMonotone(c, i+1, sb);
				 } else {
					 ch = sb.charAt(i);
				 }
			 }
			 sb.append(c[start]);
			 if (start + 1 < c.length) {
				 findMonotone(c, start+1, sb);
			 }
		 }
	 }
	 /*
	  * Intuition
One initial thought that comes to mind is we can always have a candidate answer of d999...9 
(a digit 0 <= d <= 9 followed by some number of nines.) For example if N = 432543654, we
 could always have an answer of at least 399999999.

We can do better.
 For example, when the number is 123454321, we could have a candidate of 123449999. 
 It seems like a decent strategy is to take a monotone increasing prefix of N, then decrease the number 

When does that strategy fail? If N = 333222, then our strategy would give us the candidate answer of 332999 - 
but this isn't monotone increasing. However, since we are looking at all indexes before the original 
first occurrence of a cliff, the only place where a cliff could exist, is next to where we just decremented a digit.

Thus, we can repair our strategy, by successfully morphing our answer 332999 -> 329999 -> 299999 with a linear scan.

	  * 
	  */
	 //Not my solution
	 public int monotoneIncreasingDigits(int N) {
		 char []c = Integer.toString(N).toCharArray();
		 int i =1;
		 while (i < c.length && c[i-1] <= c[i])
			 i++;
		 
		 while (i > 0 && i < c.length && c[i-1] > c[i]) {
			 //First decrement to go to previous digit
             i--;
			 c[i]--;
			
		 }
		 
		 for (int j = i+1; j < c.length; ++j) {
			 c[j] = '9';
		 }
		 return Integer.parseInt(String.valueOf(c));
	 }
}
