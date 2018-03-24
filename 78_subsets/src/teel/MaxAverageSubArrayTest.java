package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxAverageSubArrayTest {

	MaxAverageSubArray ms = new MaxAverageSubArray();
	@Test
	void test() {
		int []nums = {1,12,-5,-6,50,3};
		assertTrue(ms.findMaxAverage(nums, 4) == 12.75);
	}
	
	@Test
	void test1() {
		int []nums = {4,0,4,3,3};
		assertTrue(ms.findMaxAverage(nums, 5) == 2.8);
	}
	
	@Test
	void test2() {
		int []nums = {1,4,2,3,2};
		assertTrue(ms.findMaxAverage(nums, 5) == 2.4);
	}

}
