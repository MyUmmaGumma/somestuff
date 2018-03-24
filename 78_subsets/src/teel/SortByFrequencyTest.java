package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortByFrequencyTest {
	SortByFrequency sbf = new SortByFrequency();
	
	@Test
	void test() {
		assertTrue(sbf.frequencySort("tree").contentEquals("eert") || sbf.frequencySort("tree").contentEquals("eetr")); 
	}

}
