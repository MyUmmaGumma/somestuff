package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestPalindromicSubsequenceTest {

	LongestPalindromicSubsequence lpssq = new LongestPalindromicSubsequence();
	@Test
	void test() {
		assertTrue(lpssq.longestPalindromeSubseq("bbbab") == 4);
	}

	@Test
	void test1() {
		assertTrue(lpssq.longestPalindromeSubseq("aa") == 2);
	}
}
