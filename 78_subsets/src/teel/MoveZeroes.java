package teel;

public class MoveZeroes {
	 public void moveZeroes(int[] nums) {
		 int pos = -1;
		 for (int i = 0; i < nums.length; i++) {
			 if (nums[i] == 0 && pos == -1) {
				 pos = i;
			 } else {
				 if (pos != -1 && nums[i] != 0) {
					 nums[pos] = nums[i];
					 nums[i] = 0;
					 i = pos;
					 pos = -1;
					 
				 }
			 }
		 }
	 }
	 
	 public static void main(String []args)
	 {
		 int []nums = {1,2,3,0,5,0,1,9,8,4,0,0};
		 MoveZeroes mz = new MoveZeroes();
		 mz.moveZeroes(nums);
		 for (int num : nums) {
		 	System.out.print(num + " ");
		 }
	}
		 
}
