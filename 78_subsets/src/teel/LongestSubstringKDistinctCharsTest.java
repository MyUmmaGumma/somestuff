package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestSubstringKDistinctCharsTest {
	
	LongestSubstringKDistinctChars lskd = new LongestSubstringKDistinctChars();
	
	@Test
	void test() {
		String s = "eceba";
		assertTrue(lskd.lengthOfLongestSubstringKDistinct(s, 2) == 3);
	}

	@Test
	void testLCS() {
		String s = "aaabbacccccdddd";
		assertTrue(lskd.lengthOfLongestSubstringKDistinct(s, 1) == 5);
	}
	
	@Test
	void testSingleCharacter() {
		String s = "a";
		assertTrue(lskd.lengthOfLongestSubstringKDistinct(s, 0) == 0);
	}
	
	@Test
	void testLeet() {
		String s = "abaccc";
		assertTrue(lskd.lengthOfLongestSubstringKDistinct(s, 2) == 4);
	}
}
