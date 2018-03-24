package teel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TopKFrequentWordsTest {

	TopKFrequentWords tk = new TopKFrequentWords();
	
	@Test
	void test() {
		String []words = {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> li = tk.topKFrequent(words, 2);
		assertTrue(li.contains("love"));
		assertTrue(li.contains("i"));
		assertTrue(li.indexOf("i") == 0);
	}
	
	@Test
	void test1()
	{
		String []words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> li = tk.topKFrequent(words, 4);
		assertTrue(li.contains("the"));
		assertTrue(li.contains("sunny"));
		assertTrue(li.contains("day"));
		assertTrue(li.contains("is"));
		assertTrue(li.indexOf("the") == 0);
		assertTrue(li.indexOf("day") == 3);
	}

	@Test
	void testLexicographic()
	{
		String []words = {"a", "aa", "aaa"};
		List<String> li = tk.topKFrequent(words, 2);
		assertTrue(li.contains("a"));
		assertTrue(li.contains("aa"));
	}
}
