package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesArrayTest {
	RemoveDuplicatesArray rda = new RemoveDuplicatesArray();
	@Test
	void test() {
		int []nums = {1,2};
		assertTrue(rda.removeDuplicates(nums) == 2);
	}
	
	@Test
	void tesr() {
		int []nums = {1,2,3};
		assertTrue(rda.removeDuplicates(nums) == 3);
		assertTrue(nums[1] == 2);
	}

	@Test
	void test3() {
		int []nums = {1,2,2,3};
		assertTrue(rda.removeDuplicates(nums) == 3);
		assertTrue(nums[1] == 2);
		assertTrue(nums[2] == 3);
	}
}
