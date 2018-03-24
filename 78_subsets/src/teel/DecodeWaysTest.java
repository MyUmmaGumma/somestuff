package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecodeWaysTest {

	DecodeWays ds = new DecodeWays();
	@Test
	void test() {
		assertTrue(ds.numDecodings("101") == 1);
	}

}
