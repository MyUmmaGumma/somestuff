package teel;

public class ExcelSheet {
	public int titleToNumber(String s) {
        char []a = s.toCharArray();
        int num = 0, base = 0;
        for (int i = 0; i < a.length; i++) {
        		//if (base )
			base = base*26 + (a[i] - 'A' + 1);
		}
        return base;
    }
	
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char)(n %26  + 'A'));
			n = n/26;
		}
		sb.reverse();
		return sb.toString();
    }
}
