package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WordLadderTest {
	WordLadder wl = new WordLadder();
	
	static List<String> wordList;
	
	@BeforeAll
	static void beforeAll()
	{
		wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		//wordList.add("cog");
		wordList.add("c");
		wordList.add("b");
		wordList.add("a");
	}
	
	@Test
	void test() {
		assertTrue(wl.ladderLength("hit", "cog", wordList) == 0);
	}
	
	@Test
	void test1() {
		assertTrue(wl.ladderLength("a", "c", wordList) == 2);
	}
	
	@Test
	void test2() {
		assertTrue(wl.ladderLength("hit", "bog", wordList) == 0);
	}

}
