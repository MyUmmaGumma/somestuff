package teel;

public class ReverseString {
   public String reverseWords(String s) {
	   if (s.isEmpty()) { return s; }
	   
	   StringBuilder sb = new StringBuilder();
	   //find start of characters
	   int i = 0;
	   for( i = 0; i < s.length(); i++) {
		   if (s.charAt(i) != ' ') {
			   break;
		   }
	   }
	  //find end of characters
	   int j = s.length()-1;
	   for( ; j > 0; j--) {
		   if (s.charAt(j) != ' ') {
			   break;
		   }
	   }
	   
	   if (j == 0) {
		   if (Character.isLetterOrDigit(s.charAt(0))) {
			   sb.append(s.charAt(0));
			   return sb.toString();
		   } else {
			   return sb.toString();
		   }
	   }
	   
	   if (i == j) {
		   sb.append(s.charAt(i));
		   return sb.toString();
	   }
	   
	   int beg = 0, k =0;
	   for (k = j; j >= i; j--) {
		   if (s.charAt(j) == ' ') {
			   if (k == 0) {
				   continue;
			   }
			   
			   sb.append(s.substring(beg, k+1));
			   sb.append(" ");
			   k = 0;
		   } else {
			   beg = j;
			   if (k == 0) {
				   k = j;
			   }
		   }
	   }
	   
	   if (beg == 0) {
		   sb.append(s.substring(beg, k+1));
	   } else if (beg > 0) {
		   sb.append(s.substring(beg, k+1));
	   }
	   return sb.toString();
   } 
   
   
   public static void main(String []args)
   {
	   ReverseString rs = new ReverseString();
	   System.out.println(rs.reverseWords("fat    This is a tree    "));
	   System.out.println(rs.reverseWords("fat"));
	   System.out.println("A"+rs.reverseWords("  ")+"B");
	   System.out.println("A"+rs.reverseWords(" ")+"B");
	   System.out.println("A"+rs.reverseWords(" 1")+"B");
	   System.out.println(rs.reverseWords("   b  "));
	   System.out.println(rs.reverseWords("b"));
	   System.out.println(rs.reverseWords("   a   b "));
   }
}
