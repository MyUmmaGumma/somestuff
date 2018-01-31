package teel;

public class BigInteger {
	public String multiply(String num1, String num2) {
		
		StringBuilder []ind = new StringBuilder[num1.length()];
		for (int i = num1.length()-1, k = 0; i>=0 ; i--)
		{
			
			int ii = num1.charAt(i) - '0';
			int carry = 0, remainder = 0;
			ind[k] = new StringBuilder();
			StringBuilder current = ind[k];
			for (int j = num2.length() -1; j >= 0; j--) {
				
				
				int jj = num2.charAt(j) - '0';
				 
				remainder = ((ii * jj) + carry) % 10;
				carry = ((ii * jj) + carry) / 10;
				current.insert(0, Character.forDigit(remainder, 10));
			}
			current.insert(0, Character.forDigit(carry, 10));
			for (int l = 0; l < k; l++) {
				ind[k].append('0');
			}
			k++;
		}
		/* for (int i = 0; i < ind.length; i++) {
			System.out.println(ind[i].toString());
		}*/
		
		String running=ind[0].toString();
		for (int i = 1; i < ind.length;i++) {
			//System.out.print("Adding " + running);
			running = add(running, ind[i].toString());
			//System.out.println(" " + ind[i].toString() + " to get " + running);
		}
		int i = 0;
		for ( i = 0; i < running.length();i++) {
			if (running.charAt(i) != '0') {
				break;
			}
		}
		if (i == running.length()) {
			return "0";
		} else {
			return running.substring(i);
		}
    }
	
	public String add(String num1, String num2)
	{
		int carry = 0, remainder = 0;
		StringBuilder sb = new StringBuilder();
		int i , j;
		for ( i = num1.length()-1, j = num2.length()-1; i>=0 && j >=0; i--,j--) {
			int ii = num1.charAt(i) - '0';
			int jj = num2.charAt(j) - '0';
			
			remainder = (ii + jj + carry) %10;
			carry = (ii + jj + carry) /10;
			sb.insert(0, Character.forDigit(remainder, 10));
		}
		if (i >= 0) {
			for (; i >= 0; i--) {
				int ii = num1.charAt(i) - '0';
				remainder = (ii + carry) %10;
				carry = (ii + carry) /10;
				
				sb.insert(0, Character.forDigit(remainder, 10));
			}
		} else if (j >= 0)
			for (; j >= 0; j--) {
			int jj = num2.charAt(j) - '0';
			remainder = (jj + carry) %10;
			carry = (jj + carry) /10;
			
			sb.insert(0, Character.forDigit(remainder, 10));
		}
		sb.insert(0, Character.forDigit(carry, 10));
		String running =  sb.toString();

		for ( i = 0; i < running.length();i++) {
			if (running.charAt(i) != '0') {
				break;
			}
		}
		if (i == running.length()) {
			return "0";
		} else {
			return running.substring(i);
		}
		
	}
	
	public static void main(String []args)
	{
		BigInteger bi = new BigInteger();
		String s1 = "1234";
		String s2 = "4321";
		System.out.println(bi.multiply(s1, s2));
		System.out.println(bi.multiply("1000", "100"));
		System.out.println(bi.multiply("0010", "0100"));
		System.out.println(bi.multiply("113456", "432156"));
		System.out.println(bi.multiply("0", "0"));
	}
}
