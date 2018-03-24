package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskSchedulerTest {
	TaskScheduler t = new TaskScheduler();
	@Test
	void test() {
		char []tasks = {'A', 'B','A', 'B','A', 'B','A', 'B'};
		t.leastInterval(tasks, 2);
	}

}
