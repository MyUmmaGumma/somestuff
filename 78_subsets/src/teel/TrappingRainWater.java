package teel;

public class TrappingRainWater {
	 public int trap(int[] height) {
		 if (height.length <= 1) return 0;
		 
		 int []leftmax = new int [height.length];
		 int []rightmax = new int [height.length];
		 
		 leftmax[0] = height[0];
		 rightmax[height.length - 1] = height[height.length - 1];
		 for (int i = 1; i < height.length; i++) {
			 leftmax[i] = Math.max(leftmax[i-1], height[i]);
		 }
		 for (int i = height.length - 2; i >= 0;i--) {
			 rightmax[i] = Math.max(rightmax[i+1], height[i]);
		 }
		 int trap = 0;
		 for (int i = 1; i < height.length;i++) {
			 int possible = Math.min(leftmax[i], rightmax[i]) - height[i];
			 if (possible > 0) {
				 trap += possible;
			 }
		 }
		 return trap;
				 
	 }
	 
	 public static void main(String []args)
	 {
		 int []arr = {2,0,2};
		 TrappingRainWater trp = new TrappingRainWater();
		 System.out.println(trp.trap(arr));
	 }
}
