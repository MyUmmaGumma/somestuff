package teel;
/*
 * Outer while loop: Maintain invariant that at least one character of t is unmatched as we
 * iterate past characters in s. Once the invariant is violated - that is when all characters
 * of t are found in the current window of s being examined, we fall into the inner loop.
 * 
 * Inner while loop: Maintain invariant that between start and end, we will contain the
 * current minimum window substring of t in s.
 * Every time we advance inside the 2nd while loop, we reduce the distance between start 
 * and end and two things happen then
 * 1. As we reduce the size of the window to get a smaller window, we increment the counts of
 *    ALL characters in the window.
 *    The reason we do that is that we are trying to find the first character contained in t 
 *    that we are going to overrun such that the inner loop invariant is violated. It could be
 *    that there are multiple occurrences of a single character in the current window of t 
 *    that is contained in s, in which case we should violate the inner loop invariant only
 *    when the current window moves past the last occurrence such of a character in T such that
 *    not all characters of t are contained in S anymore
 * 2. We maintain at most a single character difference between t and s at the time of exiting 
 *    the inner loop which is what we want to do because we are advancing by a single character
 *    at a time in the outer loop. (It is also going to be the occurrence of that same character
 *    in s as we iterate in the outer loop that will allow us to fall into the inner loop again)   
 * */
public class MinimumWindowSubstring {
	String minWindow(String s1, String t1) {
		int []m = new int [128];
		char []s = s1.toCharArray();
		char []t = t1.toCharArray();
		
		// Statistic for count of char in t
		for (char c : t) m[c]++;
		// counter represents the number of chars of t to be found in s.
		int start = 0, end = 0, counter = t1.length(), minStart = 0, minLen = Integer.MAX_VALUE;
		int size = s1.length();
		
		// Move end to find a valid window.
		while (end < size) {
			// If char in s exists in t, decrease counter
			if (m[s[end]] > 0)
				counter--;
			// Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
			m[s[end]]--;
			end++;
			// When we found a valid window, move start to find smaller window.
			while (counter == 0) {
				if (end - start < minLen) {
					minStart = start;
					minLen = end - start;
				}
				m[s[start]]++;
				// When char exists in t, increase counter.
				if (m[s[start]] > 0)
					counter++;
				start++;
			}
		}
		if (minLen != Integer.MAX_VALUE) {
			return s1.substring(minStart, minStart+minLen);
		}
		return "";
	}
	
	public static void main(String []args)
	{
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}
}
