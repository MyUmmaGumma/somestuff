package teel;

import java.util.StringTokenizer;

public class RotateWordsInString {
	/* public void reverseWords(char[] str) {
		StringBuilder sb = new StringBuilder(new String(str));
		sb.reverse();
		String s = sb.toString();
		String []tokens = s.split("\\s+");
		sb.delete(0, sb.length());
		for (String token : tokens) {
			StringBuilder word = new StringBuilder(token);
			sb.append(word.reverse());
			sb.append(' ');
		}
		str = sb.toString().toCharArray();
		System.out.println(str);
    }*/
	
	private void reverse(char []str, int begin, int end)
	{
		char temp = ' ';
		while (begin < end) {
			temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			begin++;end--;
		}
	}
	
	public void reverseWords(char[] str) {
		reverse(str, 0, str.length -1);
		int begin = 0, end = 0, i;
		for (i = begin; i < str.length; i++) {
			char c = str[i];
			if (c == ' ') {
				reverse(str, begin, i-1);
				begin = i+1;
			}
		}
		reverse(str, begin, i-1);
	}
}
