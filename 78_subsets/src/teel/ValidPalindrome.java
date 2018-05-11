package teel;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		String s1 = s.toLowerCase();
		int i = 0, j = s1.length()-1;
		if (s.isEmpty() || j == 0) {
			return true;
		}
		for(; i < j;) {
			if (!Character.isLetterOrDigit(s1.charAt(i))) {
				i++; continue;
			}
			if (!Character.isLetterOrDigit(s1.charAt(j))) {
				j--; continue;
			}

			if (s1.charAt(i) != s1.charAt(j)) {
				return false;
			} else {
				i++; j--;
			}
		}
		return true;
    }
	
	private boolean isPalindromeInRange(char []schars, int i, int j)
	{
		int start = i, end = j;
		while (start <= end) {
			if (schars[start] != schars[end]) {
				return false;
			}
			start++; end--;
		}
		return true;
	}
	
	public boolean validPalindrome(String s) {
		char []schars = s.toCharArray();
		int start = 0, end = schars.length;
		while (start <= end) {
			if (schars[start] != schars[end]) {
				return  isPalindromeInRange(schars, start+1, end) ||
						isPalindromeInRange(schars, start, end-1);
			}
			start++; end--;
		}
		return true;
	}
	
	public boolean validPalindrome1(String s) {
        char []schars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        boolean once = false;
        while (start <= end) {
        		if (schars[start] != schars[end]) {
        			if (schars[start+1] == schars[end] && once == false) {
        				once = true;
        				start+=2; end--;
        				continue;
        			} else if(schars[start] == schars[end-1] && once == false) {
        				once = true;
        				start++; end -= 2;
        				continue;
        			} else {
        				return false;
        			}
        		}
        		start++;end--;
        }
        return true;
    }
	
	
	
	public static void main(String []args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println("\"\" - "+vp.isPalindrome(""));
		System.out.println("a - "+vp.isPalindrome("a"));
		System.out.println("ab -"+vp.isPalindrome("ab"));
		System.out.println("Madam - "+vp.isPalindrome("madam"));
		System.out.println("race a car -"+vp.isPalindrome("race a car"));
		System.out.println("A man, a plan, a canal: Panama -"+vp.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
