package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimumSizeSubarraySumTest {

	MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
	
	@Test
	void test() {
		int []nums = {2,3,1,2,4,3};
		assertTrue(ms.minSubArrayLen(7, nums) == 3);
	}

}
