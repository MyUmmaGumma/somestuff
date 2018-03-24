package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExcelSheetTest {
	ExcelSheet es = new ExcelSheet();
	
	@Test
	void testA() {
		assertTrue(es.titleToNumber("A") == 1);
	}
	
	@Test
	void testAA() {
		assertTrue(es.titleToNumber("AA") == 27);
	}
	
	@Test
	void testLongSequence() {
	//	assertTrue(es.titleToNumber("AAAAAAAAAAAAAAAAAAAAAAAAAA") == Integer.MAX_VALUE);
	}

	@Test
	void testconvertToTitle() {
		assertTrue(es.convertToTitle(308915779) == "AAAAAC");
	}
	
	@Test
	void testconvertToTitle1() {
		assertTrue(es.convertToTitle(1).contentEquals("A"));
	}
	@Test
	void testconvertToTitle26() {
		assertTrue(es.convertToTitle(26).contentEquals("Z"));
	}
}
