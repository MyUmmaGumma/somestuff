package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromicSubstringsTest {

	PalindromicSubstrings ps = new PalindromicSubstrings();
	
	@Test
	void test() {
		assertTrue(ps.countSubstrings("bbbab") == 9);
	}
	
	@Test
	void test_fdsklf() {
		assertTrue(ps.countSubstrings("fdsklf") == 6);
	}

}
