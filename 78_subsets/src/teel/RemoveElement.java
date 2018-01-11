package teel;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int pos = -1;
		 for (int i = 0; i < nums.length; i++) {
			 if (nums[i] == val && pos == -1) {
				 pos = i;
			 } else {
				 if (pos != -1 && nums[i] != val) {
					 nums[pos] = nums[i];
					 nums[i] = val;
					 i = pos;
					 pos = -1;
					 
				 }
			 }
		 }
		 if (pos == -1) {
			return nums.length; 
		 } 
		 return pos;
    }
	
	public static void main(String []args)
	 {
		 int []nums = {1};
		 RemoveElement mz = new RemoveElement();
		 int x = mz.removeElement(nums, 3);
		 for (int num : nums) {
		 	System.out.print(num + " ");
		 }
		 System.out.println(x);
	}
}
