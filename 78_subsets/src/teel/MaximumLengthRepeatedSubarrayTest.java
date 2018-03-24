package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximumLengthRepeatedSubarrayTest {

	MaximumLengthRepeatedSubarray ms = new MaximumLengthRepeatedSubarray();
	@Test
	void test() {
		int []A = {1,2,3,2,1};
		//int []A = {1,2,3,4,5};
		int []B = {3,2,1,4,7};
		assertTrue(ms.findLength(A, B) == 3);
	}

}
