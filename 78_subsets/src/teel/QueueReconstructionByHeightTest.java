package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueReconstructionByHeightTest {

	QueueReconstructionByHeight q = new QueueReconstructionByHeight();
	@Test
	void test() {
		int [][]qa = {{5,0}, {6,1},{4,4},{5,2},{7,1},{7,0}};
		q.reconstructQueue(qa);
	}

}
