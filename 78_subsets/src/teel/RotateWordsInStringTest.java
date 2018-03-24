package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RotateWordsInStringTest {
	RotateWordsInString rs = new RotateWordsInString();
	@Test
	void test() {
		String str = "The sky is blue";
		System.out.println(str);
		char []str1 = new char [str.length()];
		str1 = Arrays.copyOf(str.toCharArray(), str.length());
		rs.reverseWords(str1);
		equals(Arrays.compare(str1, (new String("blue is sky The")).toCharArray()));
	}

}
