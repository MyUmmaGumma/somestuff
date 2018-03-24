package teel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MeetingRooms2Test {
	MeetingRooms2 m2 = new MeetingRooms2();
  
	
	@Test
	void test() {
		Interval []in = new Interval[3];
		in[0] = new  Interval(1,5);
		in[1] = new  Interval(8,9);
		in[2] = new  Interval(8,9);
		
		assertTrue(m2.minMeetingRooms(in) == 2);
	}
	
	@Test
	void test3() {
		Interval []in = new Interval[3];
		in[0] = new  Interval(0,30);
		in[1] = new  Interval(5,10);
		in[2] = new  Interval(15,20);
		assertTrue(m2.minMeetingRooms(in) == 2);
	}

	@Test
	void test1() {
		Interval []in = new Interval[2];
		in[0] = new  Interval(5,8);
		in[1] = new  Interval(6,8);
		
		assertTrue(m2.minMeetingRooms(in) == 2);
	}
	
	@Test
	void test2() {
		Interval []in = new Interval[3];
		in[0] = new  Interval(6,15);
		in[1] = new  Interval(13,20);
		in[2] = new  Interval(6,17);
		
		assertTrue(m2.minMeetingRooms(in) == 3);
	}
	
	
}
