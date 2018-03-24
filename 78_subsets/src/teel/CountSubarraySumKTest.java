package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountSubarraySumKTest {

	CountSubarraySumK cs = new CountSubarraySumK();
	
	@Test
	void test() {
		int []a = {1,1,1};
		assertTrue(cs.subarraySum(a, 2) == 2);
	}
	
	@Test
	void test3() {
		int []a = {-2,1,4,-1,2,1,3};
		assertTrue(cs.subarraySum(a, 3) == 4);
	}

}
