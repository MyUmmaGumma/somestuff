package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class ReverseVowelsTest {
	ReverseVowels rv = new ReverseVowels();
	@Test
	void test() {
		assertTrue(rv.reverseVowels("leetcode").contentEquals("leotcede"));
		assertTrue(rv.reverseVowels("hello").contentEquals("holle"));
		
	}
	
	@Test
	void aatest() {
		assertTrue(rv.reverseVowels("aA").contentEquals("Aa"));
	}

}
