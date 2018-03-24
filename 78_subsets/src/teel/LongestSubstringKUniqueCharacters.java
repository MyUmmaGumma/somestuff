package teel;

public class LongestSubstringKUniqueCharacters {
	//substring window
	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		char []schars = s.toCharArray();
		int j = 0, count = 0, max = 0; 
		char []map = new char[256];
		for (int i = 0; i < schars.length; i++) {
			if (map[schars[i]] == 0) {
				count++;
			}
			map[schars[i]]++;
			while (count > k) {
				map[schars[j]]--;
				if (map[schars[j]] == 0) {
					count--;
				}
				j++;
			}
			max = Math.max(max, j - i +1);
		}
		return max;
	}
}
