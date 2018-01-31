package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnearestNeighbors {
	int binarySearch(int arr[], int l, int r, int x)
	{
	  while (l <= r)
	  {
	    int m = l + (r-l)/2;
	 
	    // Check if x is present at mid
	    if (arr[m] == x) 
	        return m;  
	 
	    // If x greater, ignore left half  
	    if (arr[m] < x) 
	        l = m + 1; 
	 
	    // If x is smaller, ignore right half 
	    else
	         r = m - 1; 
	  }
	 
	  // if we reach here, then element was not present
	  return -1; 
	}
	
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		
		List<Integer> li = new ArrayList<Integer>();
		Integer []input = new Integer[arr.length];
		for (int  i = 0; i < arr.length; i++) {
			input[i] = arr[i];
		}
		
		Arrays.sort(input, (a,b) -> (a==b) ? a - b : (Math.abs(a - x) - Math.abs(b-x)) );
		for (int  i = 0; i < arr.length; i++) {
			System.out.print(input[i] + " ");
		}
		/* int res = binarySearch(arr, 0, arr.length-1, x);
		if (res == -1) {
			return li;
		}
		if (arr.length == 1) {
			li.add(x);
			return li;
		}
		
		//Calculate how many elements to read before and after x (T - means target)
		int before = 0, after = 0, beforeT = k/2, afterT = k/2;
		if (k % 2 == 1) {
			if (res > k/2 + 1) {
				beforeT = k/2 + 1;
				afterT = k/2;
			} else {
				beforeT = res;
				afterT = (k - res) + 1;
			}
		} else {
			if (arr.length - res > k/2 + 1) {
				afterT = k/2 ;
				beforeT = k/2;
			} else {
				afterT = (arr.length - res + 1); 
				beforeT = (k - afterT);
			}
		}
		for (int i = res; i >= 0; i--) {
			while (before < beforeT) {
				li.add(arr[i]);
				before++;
				i--;
			}
		}
		
		for (int i = res + 1; i < arr.length; i++) {
			while (after < afterT) {
				li.add(arr[i]);
				after++;
				i++;
			}
		}*/
		
		//Collections.sort(list);
		
		return li;
    }
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int lo = 0, hi = arr.length - k;
		while (lo < hi) {
			int mid = lo + (hi - lo)/2;
			if (x - arr[mid]  > arr[mid+k] - x) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		List<Integer> li = new ArrayList<Integer>();
		for (int i = lo; i < lo+k; i++) {
			li.add(arr[i]);
		}
		return li;
	}
	
	public static void main(String []args)
	{
		KnearestNeighbors kn = new KnearestNeighbors();
		int []arr = {1,2,3,4,5,6,7,8};
		kn.findClosestElements(arr, 6, 6);
	}
}
