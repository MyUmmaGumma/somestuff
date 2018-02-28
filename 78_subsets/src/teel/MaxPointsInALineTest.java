package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxPointsInALineTest {

	
	MaxPointsOnALine mal = new MaxPointsOnALine();
	Point x = new Point(3,5);
	Point y = new Point(2,4);
	
	
	@Test
	void test() {
		Point.Line l = mal.findLineThrough2Points(x, y);
		assertTrue(mal.doesLineGoThroughPoints(x, l));
		assertTrue(mal.doesLineGoThroughPoints(y, l));
	}
	
	@Test
	void getArrayOfPointPairs()
	{
		Point p1 = new Point (-1,-2);
		Point p2 = new Point (8,-4);
		Point p3 = new Point (3,7);
		Point []arr = {x,y,p1,p2,p3};
		Point [][]ppairs = mal.getArrayOfPointPairs(arr);
		System.out.println(ppairs.length);
		equals(ppairs.length == 10);
	}
}
