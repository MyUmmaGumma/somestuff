package teel;

public class ReadNGivenRead4 {
	private int read4(char[] buf)
	{
		return 0;
	}
	char []lbuf = new char [4];
	 int bufPtr, curr = 0;
	 public int read(char[] buf, int n) {
	    int rd=  0;
	    while (rd < n) {
	    		if (bufPtr == 0) {
	    			curr = read4(lbuf);
	    		}
	    		if (curr == 0) break;
               //Copy over what was read in the call to read4 and stuff from prior calls - 
	    		//up until how much was asked (n bytes)
	    		while (rd < n && bufPtr < curr) {
	    			buf[rd++] = lbuf[bufPtr++]; 
	    		}
                // If wrote more than or equal to what was read 
	    		   // (more when greater than 4 was written - one current read, + remaining previous read) ,
	    		   // reset our cached bufPtr value
	    		if (bufPtr >= curr) bufPtr = 0;
	    }
	    return rd;
	 }
}
