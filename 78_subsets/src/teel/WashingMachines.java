package teel;

public class WashingMachines {
	/*
	Instead of using some DP methodology to solve the problem, I have a very intuitive way to approach the solution.

	Think about the machine i, after we make all machines have the same dresses, how many dresses will be passed through machine i?
	Let’s denote the current sum of dresses of machines [0...i-1] as leftSums[i], and the current sum of dresses of machines [i+1...n-1] as rightSums[i].
	Let’s denote the expected sum of dresses of machines [0...i-1] as expLeft, 
	which means after all dresses are equally distributed, the sum of address 
	in machines [0...i-1] should be expLeft.
	
	The same logic applies to machines [i+1...n-1], denoted as expRight.

	If expLeft is larger than leftSums[i], that means no matter how you move the dresses, 
	there will be at least expLeft - leftSums[i] dresses being moved to left of machine i,
	which means pass through machine i. For the right machines of machine i, the logic remains the same. 
	So we could conclude that the minimum dresses passed through machine i will be:

	left = expLeft > leftSums[i] ? expLeft - leftSums[i] : 0;
	right = expRight > rightSums[i] ? expRight - rightSums[i] : 0;
	total = left + right;
	With this answer in mind, we could know that the minimum moves is the maximum dresses that pass through for each single machine,
    because for each dress, it will require at least one move. 
    
    Hence the following solution. The code could be more concise, but I will leave it here for purpose of explanation.

	If you have any doubts or suggestions for this solution, any comments are welcome.
*/
	    public int findMinMoves(int[] machines) {
	        int n = machines.length;
	        int sum = 0;
	        for (int num : machines) {
	            sum += num;
	        }
	        if (sum % n != 0) {
	            return -1;
	        }
	        int avg = sum / n;
	        int[] leftSums = new int[n];
	        int[] rightSums = new int[n];
	        for (int i = 1; i < n; i ++) {
	            leftSums[i] = leftSums[i-1] + machines[i-1];
	        }
	        for (int i = n - 2; i >= 0; i --) {
	            rightSums[i] = rightSums[i+1] + machines[i+1];
	        }
	        int move = 0;
	        for (int i = 0; i < n; i ++) {
	            int expLeft = i * avg;
	            int expRight = (n - i - 1) * avg;
	            int left = 0;
	            int right = 0;
	            if (expLeft > leftSums[i]) {
	                left = expLeft - leftSums[i];
	            } 
	            if (expRight > rightSums[i]) {
	                right = expRight - rightSums[i];
	            }
	            move = Math.max(move, left + right);
	        }
	        return move;
	    }
	}

