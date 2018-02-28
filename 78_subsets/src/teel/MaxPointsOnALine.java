package teel;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

import teel.Point.Line;

public class MaxPointsOnALine {
	
	
	public Point.Line findLineThrough2Points(Point x, Point y) {
		// TODO Auto-generated method stub
		
		int m = (y.y - x.y)/(y.x - x.x);
		int c = y.y - (m * y.x);
		return x.new Line(m, c);
	}
	
	public boolean doesLineGoThroughPoints(Point p, Line l) {
		// TODO Auto-generated method stub
		if (Math.abs(p.y - (p.x * l.m) - l.c) == 0) {
			return true;
		}
		return false;
	}

	public Point[][] getArrayOfPointPairs(Point[] arr) {
		// TODO Auto-generated method stub
		int len = ((arr.length -1) * arr.length)/2;
		Point [][]parr = new Point [len][];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length && j != i; j++) {
				parr[k++] = new Point[] {arr[i], arr[j]};
			}
		}
		return parr;
	}

	public int maxPoints(Point[] points) {
		Map<BigDecimal, Integer> m = new HashMap<>();
		if (points == null) return 0;
        if (points.length <= 2) return points.length;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Point x = points[i];
			int samex = 1;
			int samepoint = 0;
			for (int j = 0; j < points.length && i != j; j++) {
				Point y = points[j];
				if (x.x == y.x && x.y == y.y) 
					samepoint++;
				if (x.x == y.x) 
				{
					samex++; continue;
				}
                BigDecimal slope = new BigDecimal(y.y - x.y).divide(new BigDecimal(y.x - x.x), MathContext.DECIMAL128);

				m.putIfAbsent(slope, 1);
				m.compute(slope, (k, v) -> v + 1);
				max = Math.max(max, m.get(slope) + samepoint);
			}
			max = Math.max(max, samex);
		}
		/*
		 * for (int i = 0; i < points.length; i++) {
      int sameX = 1;
      int samePoint = 0;
      Map<BigDecimal, Integer> slopes = new HashMap<>();
      int x1 = points[i].x;
      int y1 = points[i].y;
      for (int j = 0; j < points.length; j++) {
        if (i != j) {
          int x2 = points[j].x;
          int y2 = points[j].y;

          if (x2 == x1 && y2 == y1) {
            samePoint++;
          }

          if (x2 == x1) {
            sameX++;
            continue;
          }

          BigDecimal slope = new BigDecimal(y2 - y1).divide(new BigDecimal(x2 - x1), MathContext.DECIMAL128);
          slopes.putIfAbsent(slope, 1);
          slopes.compute(slope, (k, v) -> v + 1);
          max = Math.max(max, slopes.get(slope) + samePoint);
        }
      }

      max = Math.max(max, sameX);
    }
		 */
		
		return max;
	}
	
	public static void main(String []args)
	{
		Point p = new Point(0,0);
		Point p1 = new Point(-1,-1);
		Point p2 = new Point(2,2);
		MaxPointsOnALine m = new MaxPointsOnALine();
		Point []ps = new Point[] {p, p1, p2};
		m.maxPoints(ps);
	}
}
