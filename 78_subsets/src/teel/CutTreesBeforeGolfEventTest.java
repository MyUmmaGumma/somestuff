package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CutTreesBeforeGolfEventTest {
	CutTreesBeforeGolfEvent c = new CutTreesBeforeGolfEvent();
	@Test
	void test() {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);l1.add(2);l1.add(3);
		List<Integer> l2 = new ArrayList<>();
		l2.add(0);l2.add(0);l2.add(4);
		List<Integer> l3 = new ArrayList<>();
		l3.add(7);l3.add(6);l3.add(5);
		List<List<Integer>> ll  = new ArrayList<>();
		ll.add(l1);ll.add(l2);ll.add(l3);
		c.cutOffTree(ll);
	}
	
	@Test
	void test1() {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);l1.add(2);l1.add(3);
		List<Integer> l2 = new ArrayList<>();
		l2.add(0);l2.add(0);l2.add(0);
		List<Integer> l3 = new ArrayList<>();
		l3.add(7);l3.add(6);l3.add(5);
		List<List<Integer>> ll  = new ArrayList<>();
		ll.add(l1);ll.add(l2);ll.add(l3);
		c.cutOffTree(ll);
	}

}
