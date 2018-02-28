package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

class PartitionLabelsTest {

	PartitionLabels p = new PartitionLabels();
	@Test
	void partitionLabelstest() {
		List<Integer> li = p.partitionLabels("ababcbacadefegdehijhklij");
		assertTrue(li.size() == 3);
	}

	@Test
	void partitionLabelstestSingleChar() {
		List<Integer> li = p.partitionLabels("aaaaaaaaaaaaaaaaaaaaa");
		assertTrue(li.size() == 1);
	}
}
