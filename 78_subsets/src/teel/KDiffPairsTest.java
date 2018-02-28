package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KDiffPairsTest {

	KDiffPairs kd = new KDiffPairs();
	@Test
	void test1() {
		int []nums = {3,1,4,1,5};
		assertTrue(kd.findPairs(nums, 2) == 2);
	}
	
	@Test
	void test2() {
		int []nums = {1,2,3,4,5};
		assertTrue(kd.findPairs(nums, 1) == 4);
	}

	@Test
	void test3() {
		int []nums = {1,3,1,5,4};
		assertTrue(kd.findPairs(nums, 0) == 1);
	}
	@Test
	void testNegativeK() {
		int []nums = {1,2,3,4,5};
		assertTrue(kd.findPairs(nums, -1) == 0);
	}
	@Test
	void testDups() {
		int []nums = {1,1,1,2,1};
		assertTrue(kd.findPairs(nums, 1) == 1);
	}
}
