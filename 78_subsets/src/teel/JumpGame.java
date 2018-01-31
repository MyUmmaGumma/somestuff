package teel;

public class JumpGame {
	
	public boolean canJump(int []nums)
	{
		int lastpos = nums.length - 1;
		for (int i = lastpos - 1; i >=0 ;i--) {
			if (i + nums[i] >= lastpos) {
				lastpos= i;
			}
		}
		return (lastpos == 0);
	}
	

	
	public static void main(String []args)
	{
		JumpGame jg = new JumpGame();
		
		int nums[] = {2,3,1,1,4};
		/*System.out.println(jg.canJump(nums));
		*/int nums1[] = {3,2,1,0,4};
		System.out.println(jg.canJump(nums1));
 	}
}
