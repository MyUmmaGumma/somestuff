package teel;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
	
	//Not exactly pivot but find largest index such that the element at that
	// index is less than its next element - if not -1 
	public int findPivot(int []a)
	{
		int rem = 0; boolean found = false;
		for (int i = 0; i < a.length-2; i++) {
			if (a[i] < a[i+1]) {
				rem = i;
				found = true;
			}
		}
		if (a[a.length-2] < a[a.length - 1]) {
			rem = a.length - 2;
			found = true;
		}
		
		if (found == false) {
			return -1;
		}
		return rem;
	}
	
	public int findNextPivot(int []a, int rem)
	{
		int rem1 = -1; boolean found = false;
		for(int i = 0; i < rem; i++) {
			if (a[i] > a[rem]) {
				rem1 = i;
				found = true;
			}
		}
		return rem1;
	}
	
	public static final void  swap (int[] a, int i, int j) {
		  int t = a[i];
		  a[i] = a[j];
		  a[j] = t;
		}
	
	public static int []reversing(int[] array){
	    int arraysize = array.length;
	    int[] reverse = new int [arraysize+1];
	    for(int i=1; i <= arraysize ; i++){
	        int dec= arraysize -i;
	        reverse[i] = array[dec];
	    }
	    return reverse;
	}

	public void nextPermutation(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		int p = findPivot(nums);
		if (p == -1) {
			nums = reversing(nums);
		} else {
			int rem1 = findNextPivot(nums, p);	
			swap(nums, p, rem1);
			int j = (nums.length - 1 - p)/2;
			for (int i = p; i < j; i++) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}
	}
	
	public static void main(String []args)
	{
		NextPermutation np = new NextPermutation();
		int []nums = {1,3,2};
		np.nextPermutation(nums);
		for (int i = 0; i < nums.length;i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("");
	}
}
