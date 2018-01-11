package teel;

import java.util.HashMap;

public class decode_alphabet {
	
	 static HashMap hm = new HashMap();
	 private static void createMap()
	 {
		 
		 /* hm.put("a", 1);hm.put("b", 2);hm.put("c", 3);hm.put("d", 4);hm.put("e", 5);
		 hm.put("f", 6);hm.put("g", 7);hm.put("h", 8);hm.put("i", 9);hm.put("j", 10);
		 hm.put("k", 11);hm.put("l", 12);hm.put("m", 13);hm.put("n", 14);hm.put("o", 15);
		 hm.put("p", 16);hm.put("q", 17);hm.put("r", 18);hm.put("s", 19);hm.put("t", 20);
		 hm.put("u", 21);hm.put("v", 22);hm.put("w", 23);hm.put("x", 24);hm.put("y", 25)
		 hm.put("z", 26); */
		 
		 hm.put(1, "a");hm.put(2, "b");hm.put(3, "c");hm.put(4, "d");hm.put(5, "e");
		 hm.put(6, "f");hm.put(7, "g");hm.put(8, "h");hm.put(9, "d");hm.put(10, "j");
		 hm.put(11, "k");hm.put(12, "l");hm.put(13, "m");hm.put(14, "n");hm.put(15, "o");
		 hm.put(16, "p");hm.put(17, "q");hm.put(18, "r");hm.put(19, "s");hm.put(20, "t");
		 hm.put(21, "u");hm.put(22, "v");hm.put(23, "w");hm.put(24, "x");hm.put(25, "y");
		 hm.put("z", 26);
		 
	 }
	 
	 String lookup(String s) {
		 int i = Integer.parseInt(s);
		 System.out.println("Looking up " + s + " ,value = " + i);
		 if (i == 0 || i > 26) {
			 return null;
		 }
		 return (String)hm.get(i);
	 }
	 
	 public int numDecodings1(String s, int count) {
		 if (s.length() >= 2) {
			 String s1 = lookup(s.substring(0, 2));
			 if (s1 != null) {
				 String newstring = s.substring(2);
				 if (numDecodings1(newstring, count) != 0) {
					 count++;
				 }
			 }
			 s1 = lookup(s.substring(0, 1));
			 if (s1 != null) {
				 String newstring = s.substring(1);
				 if (numDecodings1(newstring, count) != 0) {
					 count++;
				 }
			 }
			 return count;
		 } else if (s.length()  == 0){
			 return 0;
		 } else {
			 System.out.println("s = " + s);
			 String s1 = lookup(s.substring(0));
			 if (s1 != null) {
				 return 1;
			 } else {
				 return 0;
			 }
		 }
	 }
	 
	 public int numDecodings(String s) {
		 return numDecodings1(s, 0);
	 }
	 public static void main(String []args)
	 {
		 decode_alphabet da = new decode_alphabet();
		 decode_alphabet.createMap();
		 System.out.println(da.numDecodings("212"));
	 }
}
