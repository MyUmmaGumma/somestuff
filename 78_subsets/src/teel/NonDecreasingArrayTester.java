package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NonDecreasingArrayTester {

	NonDecreasingArray nca = new NonDecreasingArray();
	
	@Test
	void testCheckPossibilityRmpty() {
		nca.checkPossibility(new int [0]);
	}
	
	@Test
	void testFirstAnomaly()
	{
		assertTrue(nca.firstAnomaly(new int [0]) == -1);
		int []nums = {1,2,3,4,10,8};
		assertTrue(nca.firstAnomaly(nums) == 4);
	}
	
	@Test
	void testCheckPossibilityLastElement() {
		NonDecreasingArray nca = new NonDecreasingArray();
		int []nums = {1,2,3,4,10,8};
		assertTrue(nca.checkPossibility(nums));
	}

	@Test
	void testCheckPossibilityGeneral() {
		int []nums1 = {5,8,7,9};
		assertTrue(nca.checkPossibility(nums1));
	}
	@Test
	void testCheckPossibilityGeneral1() {
		int []nums1 = {4,2,3};
		assertTrue(nca.checkPossibility(nums1));
	}
	
	@Test
	void testCheckPossibliltyNegative() {
		int []nums = {1,2,3,4,0,2};
		assertFalse(nca.checkPossibility(nums));
	}
	
	@Test
	void testCheckPossibliltyNegative2() {
		int []nums = {4,2,1};
		assertFalse(nca.checkPossibility(nums));
	}
	
	@Test
	void testCheckPossibliltyRepeating() {
		int []nums = {2,3,3,2,4};
		assertTrue(nca.checkPossibility(nums));
	}
	@Test
	void testCheckPossibliltyArrayIndexException() {
		int []nums = {1,2,3};
		assertTrue(nca.checkPossibility(nums));
	}
	@Test
	void testCheckPossibliltyNegtaiveStart() {
		int []nums = {-1, 4, 2, 3};
		assertTrue(nca.checkPossibility(nums));
	}
}
