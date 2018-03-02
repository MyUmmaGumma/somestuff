package teel;

import java.util.Arrays;

public class FirstUniqueCharacter {
	public int firstUniqChar(String s) {
        int []c = new int [26];
        char []carr = s.toCharArray();
        Arrays.fill(c, -1);
        for (int i = 0; i < carr.length; i++) {
            int ch = carr[i] - 'a';
            if (c[ch] >= 0 || c[ch] == Integer.MAX_VALUE) {
                c[ch] = Integer.MAX_VALUE;
            }
            if (c[ch] == -1) {
                c[ch] = i;
            } 
        }
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < 26; i++) {
            if (c[i] != -1)
                min = Math.min(min, c[i]);
        }
        min = (min ==  Integer.MAX_VALUE) ? -1 : min;
        return min;
    }

}
