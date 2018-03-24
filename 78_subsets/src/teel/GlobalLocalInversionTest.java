package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GlobalLocalInversionTest {
	GlobalLocalInversion gbi = new GlobalLocalInversion();
	@Test
	void test() {
		int []A = {1,5,4,0};
		gbi.isIdealPermutation(A);
	}

}
