package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {

	LongestPalindromicSubstring ls = new LongestPalindromicSubstring();
	
	@Test
	void test() {
		assertTrue(ls.longestPalindrome("aaaa").contains("aaaa"));
	}
	
	@Test
	void test1() {
		assertTrue(ls.longestPalindrome("babad").contains("bab") ||
				ls.longestPalindrome("babad").contains("aba"));
	}

	@Test
	void test2() {
		assertTrue(ls.longestPalindrome("abb").contains("bb") ||
				ls.longestPalindrome("abb").contains("bb"));
	}
}
