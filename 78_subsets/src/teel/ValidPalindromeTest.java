package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidPalindromeTest {
	ValidPalindrome vp = new ValidPalindrome();
	
	@Test
	void test() {
		assertTrue(vp.validPalindrome("eeccccbebaeeabebccceea") == false);
	}
	@Test
	void test1() {
		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		assertTrue(vp.validPalindrome(s) == true);
	}
}
