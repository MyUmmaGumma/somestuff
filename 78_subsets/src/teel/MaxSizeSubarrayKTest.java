package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxSizeSubarrayKTest {
	MaxSizeSubarrayK k = new MaxSizeSubarrayK();
	@Test
	void test() {
		int []nums = {1,-1, 5,-2,3};
		assertTrue(k.maxSubArrayLen(nums, 3) == 4);
	}
	
	@Test
	void test2() {
		int []nums = {-2, -1, 2, 1};
		assertTrue(k.maxSubArrayLen(nums, 1) == 2);
	}
	
	@Test
	void testZero() {
		int []nums = {0,0};
		assertTrue(k.maxSubArrayLen(nums, 0) == 2);
	}
	
}
