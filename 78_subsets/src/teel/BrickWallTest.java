package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BrickWallTest {

	@Test
	void test() {
		List<Integer> li = new ArrayList<>();
		li.add(1);
		List<Integer> li1 = new ArrayList<>();
		li1.add(1);
		List<Integer> li2 = new ArrayList<>();
		li2.add(1);
		List<List<Integer>> lli = new ArrayList();
		lli.add(li);lli.add(li1);lli.add(li2);
		BrickWall bw= new BrickWall();
		assertTrue(bw.leastBricks(lli) == 3);
	}

}
