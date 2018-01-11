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
