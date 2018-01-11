package teel;

import java.util.Collection;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class WordPattern {
	 public boolean wordPattern(String pattern, String str) {
	     StringTokenizer st = new StringTokenizer(str);
	     System.out.println(st.countTokens());
	     if (st.countTokens()  != pattern.length()) {
	    	 return false;
	     }
	     Hashtable<Character, String> ht = new Hashtable<Character, String>();
	     int i = 0;
	     while(st.hasMoreTokens()) {
	    	 char c = pattern.charAt(i++);
	    	 if(ht.containsKey(c)) {
	    		 String s = ht.get(c);
	    		 String t = st.nextToken();
	    		 if (s.contentEquals(t) == false) {
	    			 return false;
	    		 }
	    	 } else {
	    		 Collection<String> col = ht.values();
	    		 String token = st.nextToken();

	    		 for (String s : col) {
	    			 if (s.contentEquals(token)) {
	    				 return false;
	    			 }
	    		 }
	    		 ht.put(c, token);
	    	 }
	     }
	     return true;
	 }
	 
	 public static void main(String []args)
	 {
		 WordPattern wp = new WordPattern();
		 //System.out.println(wp.wordPattern("abba", "Hello who who Hello"));
		 //System.out.println(wp.wordPattern("abba", "Hello who the Hello"));
		 System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
	 }
}
