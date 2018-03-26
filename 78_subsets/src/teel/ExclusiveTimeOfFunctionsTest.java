package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ExclusiveTimeOfFunctionsTest {
	ExclusiveTimeOfFunctions e = new ExclusiveTimeOfFunctions();
	@Test
	void test() {
		List<String> l = new ArrayList<>();
		l.add("0:start:0");
		l.add("1:start:2");
		l.add("1:end:5");
		l.add("0:end:6");
		assertTrue(e.exclusiveTime(4, l)[0] == 3);
	}

	@Test
	void test1() {
		List<String> l = new ArrayList<>();
		l.add("0:start:0");
		l.add("0:start:2");
		l.add("0:end:5");
		l.add("0:start:6");
		l.add("0:end:6");
		l.add("0:end:7");
		assertTrue(e.exclusiveTime(1, l)[0] == 8);
	}
}
