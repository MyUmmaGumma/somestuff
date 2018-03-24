package teel;

public class MaxAverageSubArray {
	public double findMaxAverage(int[] nums, int k) {
        int i = 1, j = 0;
        double avg = nums[0];
        double sum = nums[0];
        
        for (i = 1; i < nums.length;)
        {
            if (i >= k) {
                sum -= nums[j];
                j++;
            } 
            sum += nums[i++];
            avg = (i > k) ? Math.max(avg, sum/k) : sum/i;
            
        }
        //avg = (i >= k) ? Math.max(avg, sum/k) : Math.max(avg, sum/i);
        System.out.println(avg);
        return avg;
    }
}
