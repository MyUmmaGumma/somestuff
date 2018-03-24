package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveInvalidParanthesesTest {

	RemoveInvalidParantheses rm = new RemoveInvalidParantheses();
	@Test
	void test() {
		rm.removeInvalidParentheses("(()(()");
	}

}
