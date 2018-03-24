package teel;

class ReverseVowels {
	
	public String reverseVowels(String s) {
		if (s.length() <= 1) return s;
		int i = 0, j = s.length() - 1;
		char []s1 = s.toCharArray();
		StringBuilder sb = new StringBuilder(s);
		while (i <= j) {
			while (i <=j && !(s1[i] == 'a' || s1[i] == 'e' || s1[i] == 'i' || s1[i] == 'o' || s1[i] == 'u' ||
					s1[i] == 'A' || s1[i] == 'E' || s1[i] == 'I' || s1[i] == 'O' || s1[i] == 'U')) {
				i++;
			}
			while (i <=j && !(s1[j] == 'a' || s1[j] == 'e' || s1[j] == 'i' || s1[j] == 'o' || s1[j] == 'u' || 
					s1[j] == 'A' || s1[j] == 'E' || s1[j] == 'I' || s1[j] == 'O' || s1[j] == 'U')) {
				j--;
			}
			if (i >= j) {
				break;
			}
			if (s1[i] == s1[j]) {
				i++; j--;
				continue;
			}
			char c = s1[i]; 
			sb.setCharAt(i, s1[j]);
			sb.setCharAt(j, c);
			i++; j--;
		}
		return sb.toString();
    }
}
