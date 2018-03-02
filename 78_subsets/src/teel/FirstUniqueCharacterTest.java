package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FirstUniqueCharacterTest {

	FirstUniqueCharacter fc = new FirstUniqueCharacter();
	@Test
	void test() {
		assertTrue(fc.firstUniqChar("leetcode") == 0);
	}

	@Test
	void testNoUnique() {
		assertTrue(fc.firstUniqChar("aaaaaaa") == -1);
	}
	@Test
	void testEmpty() {
		assertTrue(fc.firstUniqChar("") == -1);
	}
	@Test
	void testSingle() {
		assertTrue(fc.firstUniqChar("aaaaaaaaan") == 9);
	}
}
