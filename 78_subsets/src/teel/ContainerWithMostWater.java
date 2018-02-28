package teel;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int first = 0, last = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (last > first) {
			max = Math.max(max, Math.min(height[first], height[last])*(last - first));
			if (height[first] > height[last]) {
				last--;
			} else {
				first++;
			}
		}
		return max;
    }
}
