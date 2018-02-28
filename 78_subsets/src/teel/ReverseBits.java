package teel;

public class ReverseBits {
	 int reverse(int in)
	{
	    int out = 0;
	    for(int j = 0; j < 32; j++) {
	        out = out | ((in & 1) <<(31 - j));
	        in = in>>1;
	    }
	    return out;
	}
	 
	 public static void main (String []args) {
		 ReverseBits rb = new ReverseBits();
		 System.out.println(rb.reverse(43261596));
	 }
}
