package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class longestPalindromeTest {
	LongestPalindromicSubstring lpss = new LongestPalindromicSubstring();
	@Test
	void test() {
		assertTrue(lpss.longestPalindrome("babad").contentEquals("bab"));
	}

	@Test
	void test_cbbd() {
		assertTrue(lpss.longestPalindrome("cbbd").contentEquals("bb"));
	}
	
	@Test
	void test_bb() {
		assertTrue(lpss.longestPalindrome("bb").contentEquals("bb"));
	}
	
	@Test
	void test_bbbb() {
		assertTrue(lpss.longestPalindrome("bbbb").contentEquals("bbbb"));
	}
}
