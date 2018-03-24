package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineReflectionTest {
	LineReflection lr = new LineReflection();
	@Test
	void testEmpty() {
		int [][]points = {{}};
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testOne() {
		int [][]points = {{1,1}};
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testPve1() {
		int [][]points = {{-4,1}, {-2, 6}, {4, 1}, {2, 6}};
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testPve2() {
		int [][]points = {{-5,1}, {-3, 6}, {3, 1}, {1, 6}};
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testPve3() {
		int [][]points = {{0, 0}, {1,0}};
		
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testNve() {
		int [][]points = {{-5,1}, {-3, 6}, {3, 1}, {1, 6}, {2,5}, {-2, 5}};
		assertFalse(lr.isReflected(points));
	}
	
	@Test
	void testNve1() {
		int [][]points = {{1,1}, {-1,-1}};
		assertFalse(lr.isReflected(points));
	}
	
	@Test
	void testPveZero() {
		int [][]points = {{0,0}, {0,0}};
		assertTrue(lr.isReflected(points));
	}
	
	@Test
	void testXAxis() {
		int [][]points = {{0,0}, {1,0}, {3,0}};
		assertFalse(lr.isReflected(points));
	}
}
