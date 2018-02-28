package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FindAnagramsInStringTest {

	FindAnagramsInString fas = new FindAnagramsInString();
	@Test
	void testFindAnagramsGeneral() {
		List<Integer> li =  fas.findAnagrams("cbaebabacd", "abc");
		assertTrue(li.size() == 2);
		
	}

	@Test
	void testFindAnagramsGeneral2() {
		List<Integer> li =  fas.findAnagrams("abab", "ab");
		assertTrue(li.size() == 3);
		
	}
}
