package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonotoneNumberTest {
	MonotoneNumber mn = new MonotoneNumber();
	@Test
	void test() {
		mn.monotoneIncreasingDigits(47958);
	}

}
