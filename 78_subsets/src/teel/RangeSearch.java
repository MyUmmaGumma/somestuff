package teel;

public class RangeSearch {
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
	
	int expandLoSearch(int num, int []nums, int loc)
	{
		int lo = -1, prev = -1;
		if (loc == -1) { return loc; }
		for (int i = loc; i >= 0;) {
			prev = i;
			i = i /2;
			if (i == 0) {
				if (nums[i] == num) {
					lo = 0;
				} else {
					lo = loc;
				}
				break;
			}
			if (i > 0) {
				System.out.print("expandLo " + nums[i] + " " + num);
				if (nums[i] == num) {
					lo = i;
				} else {
					
					lo = binarySearch(nums, i, prev, num);
					System.out.println(" expandLo " + i + " " + prev + " " + lo);
					if (lo > 0) {
						while (lo != loc && nums[lo] == nums[lo-1]) {
							prev = expandLoSearch(num, nums, lo-1);
							if (prev == -1) {
								break;
							} else {
								lo = prev;
							}
						};
						break;
					} else {
						break;
					}
				}
			}
		}
		return lo;
	}
	
	int expandHiSearch(int num, int []nums, int loc)
	{
		int hi = -1, prev = -1;
		int  j = 1;
		if (loc == -1) { return loc; }
		for (int i = loc; i < nums.length;) {
			prev = i;
			i = loc + j  * 2;
			j = j*2;
			if (i <= nums.length - 1) {
				if (nums[i] == num) {
					hi = i;
				} else {
					if (j > 2) {
						hi = expandHiSearch(num, nums, prev);
					} else {
						if (prev < i && i < nums.length) {
							hi = binarySearch(nums, prev, i, num);
						}
					}
					break;
				}
			} else {
				if (j > 2) {
					hi = expandHiSearch(num, nums, prev);
				} else {
					for(int k = prev; k < nums.length; k++) {
						if (num == nums[k]) {
							hi = k;
						}
					}
				}
			}
		}
		return hi;
	}
	
	int[] expandSearch(int num, int []nums, int loc)
	{
		int []ret = {-1,-1};
		ret[0] = expandLoSearch(num, nums, loc);
		ret[1] = expandHiSearch(num, nums, loc);
		System.out.println("Low: " + ret[0] + "High " + ret[1]);
		return ret;
	}
	
	 public int[] searchRange(int[] nums, int target) {
		 int []foo =  {-1,-1};
		 if (nums.length == 0) { return foo;} 
		 if (nums.length == 1) { 
			 if (nums[0] != target) { 
				 return foo; 
			 } else {
				 foo[0] = foo[1] = 0;
				 return foo;
			 }
		 }
		 int bs = binarySearch(nums, 0, nums.length-1, target);
		 
		 
		 System.out.println("loc = " + bs);
		 foo = expandSearch(target, nums, bs);
		 return foo;
	 }
	 
	 public static void main(String []args)
	 {
		 int target = 8; int []nums = {5,7,7,8,8,10};
		 RangeSearch rs = new RangeSearch();
		 rs.searchRange(nums, target);
	 }
}
