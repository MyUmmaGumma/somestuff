package teel;

public class Atoi {
	 public int myAtoi(String str) {
		 if (str.isEmpty()) {
			 return 0;
		 }
		 int i = 0, base = 0, sign = 0;
		 while (str.charAt(i) == ' ') i++;
		 if (str.charAt(i++) == '-') {
			 sign = 1;
		 } else {
			 sign = 1;
		 }
		 while (str.charAt(i) >= '0' && str.charAt(i) <= '9' && i < str.length()) {
			 //Check for overflow
			 if (base > Integer.MAX_VALUE/10 || 
					 (base == Integer.MAX_VALUE/10 && sign == 1 && str.charAt(i) == Integer.MAX_VALUE%10)||
					 (base == Integer.MAX_VALUE/10 && sign == -1 && str.charAt(i) == Integer.MIN_VALUE%10)) {
				 base = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				 return base;
			 }
			 base = base *10 + (str.charAt(i) - '0');
			 i++;
		 }
		 return base * sign;
	 }
}
