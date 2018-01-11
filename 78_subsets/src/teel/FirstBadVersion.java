package teel;

public class FirstBadVersion {
	int binarySearch(int l, int r)
	{
	  while (l <= r)
	  {
	    int m = l + (r-l)/2;
	    System.out.println("Searching m = " + m + " , l = " + l);
	    if (isBadVersion(m)) {
	    	if (m > 0 && isBadVersion(m-1)) {
	    		System.out.println("Searching m = " + (m - 1) + " , l = " + l);
	    		r = m -1;
	    	} else {
	    		l = m;
	    		break;
	    	}
	    } else {
	    	l = m + 1;
	    }
	  }
	   return l; 
	}

	
	public int firstBadVersion(int n) {
		return binarySearch(0, n - 1);
    }
	
	boolean isBadVersion(int version)
	{
		return false;
	}
}
