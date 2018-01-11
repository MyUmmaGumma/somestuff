package teel;

public class Findpivot {
	public int findPivot(int []arr, int lo, int hi)
	{
		int mid = (lo + hi)/2;
		if (mid == lo || mid == hi) {
			return -1;
		}
		if (arr[lo] > arr[mid]) {
			if (mid == lo+1) {
				return mid;
			}
			return findPivot(arr, lo, mid);
		}
		if (arr[hi] < arr[mid]) {
			if (mid == hi-1) {
				return hi;
			} 
			return findPivot(arr, mid, hi);
		}
		
		if (arr[lo] == arr[mid]) {
			int p = findPivot(arr, lo, mid);
			if (p == -1) {
				int q = findPivot(arr, mid, hi);
				if (q == -1) {
					return -1;
				} else {
					return q;
				}
			} else {
				return p;
			}
		}
		
		return -1;
	}
	
	
	
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
	
	int search1(int []arr, int num, int lo, int hi)
	{
		
		
		if (num == arr[lo]) {
			return lo;
		}
		if (num == arr[hi]) {
			return hi;
		}
		
		int pivot = findPivot(arr, lo, hi);
		
		if (pivot == -1) {
			return binarySearch(arr, lo, hi, num);
		}
		
		if (num == arr[pivot-1]) {
			return pivot-1;
		}
		
		if (num == arr[pivot]) {
			return pivot;
		}
		
 		if (num > arr[lo] && num < arr[pivot-1]) {
			return binarySearch(arr, lo, pivot-1, num);
		}
 		if (num > arr[pivot] && num < arr[hi]) {
 			return binarySearch(arr,pivot, hi, num);
 		}
		return -1;
	}
	
	public int search2(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			}
			return -1;
		}
        return search1(nums, target, 0, nums.length-1);
    }
	
	public boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		
		if (nums.length == 1) {
			if (nums[0] == target) {
				return true;
			}
			return false;
		}
        if (search1(nums, target, 0, nums.length-1) == -1) {
            return false;
        } else {
            return true;
        }
    }
	
	public static void main(String []args)
	{
		int []arr = {1,1};
		Findpivot fp = new Findpivot();
		System.out.println(fp.search(arr, 1));
	}
}
