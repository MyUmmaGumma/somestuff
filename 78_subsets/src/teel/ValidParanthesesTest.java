package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParanthesesTest {
	ValidParantheses vp = new ValidParantheses();
	
	@Test
	void test() {
		assertTrue(vp.isValid("]") == false);
	}
	@Test
	void test1() {
		assertTrue(vp.isValid("([)]") == false);
	}

}
