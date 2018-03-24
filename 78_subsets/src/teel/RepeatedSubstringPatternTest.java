package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepeatedSubstringPatternTest {
	RepeatedSubstringPattern rp = new RepeatedSubstringPattern();
	@Test
	void test() {
		assertTrue(rp.repeatedSubstringPattern("abab") == true);
	}
	
	@Test
	void testFalse1() {
		assertTrue(rp.repeatedSubstringPattern("aabaaba") == false);
	}

}
