	package teel;

import java.util.Arrays;

public class ArrowsBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
		for (int i  = 0; i < points.length;i++) {
			System.out.print("(" + points[i][0] + ", " + points[i][1] + ") ");
		}
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		System.out.println();
		for (int i  = 0; i < points.length;i++) {
			System.out.print("(" + points[i][0] + ", " + points[i][1] + ") ");
		}
		int count = 1, y = points[0][1];
		/* System.out.println("Start with 1");
		boolean flag = false;
*/
		for (int i  = 1; i < points.length;i++) {
			/*flag = false;
			System.out.println("Comparing " + points[i][0] + "," + points[i][1] +
					" and " + points[i+1][0] + "," + points[i+1][1] +  " y= " + y);
			if (y >= points[i+1][0]) {
				int j = i+1;
				
				for (j = i+1; j <  points.length - 1;) {
					System.out.println("Comparing " + y + 
							" and " + points[j][0] + "," + points[j][1] +  " y= " + y);
					
					if (y >= points[j][0]) {
						
						y = points[j][1];
						j++;
					} else {
						System.out.println("Increment");
						count++;
						flag = true;
						y = points[j][1];
						break;
					}
				}
				
				i = j-1;
			} else {
				System.out.println("Increment");
				flag = true;
				y = points[i+1][1];
				count++;
			} */
			 if (y >= points[i][0]) {
	                continue;
	            }
	            count++;
	            y = points[i][1];
		}
		/*int i = points.length -1;
		System.out.println("Last: Comparing " + y + 
 				" and " + points[i][0] + "," + points[i][1] + " y= " + y);
		if (!flag && y < points[i][0]) {
			System.out.println("Increment");
			count++;
		} 
		*/
		return count;
    }
	
	public static void main(String []args)
	{
		ArrowsBurstBalloons abb = new ArrowsBurstBalloons();
		int [][]points0 = {{10,16}, {2,8}, {1,6}, {7,12}};
		System.out.println(abb.findMinArrowShots(points0));
		System.out.println("-------------------------------------------------------");
		
		int [][]points = {{10,16}, {2,8}, {1,6}, {7,12}, {14,15}, {17, 18}, {0,1}};
		System.out.println(abb.findMinArrowShots(points));
		System.out.println("-------------------------------------------------------");
		int [][]points1 = {{1,2}, {3,4}, {5,6}, {7,8}};
		System.out.println(abb.findMinArrowShots(points1));
		System.out.println("-------------------------------------------------------");
		int [][]points2 = {{-1,1}, {0,1}, {2,3}, {1,2}};
		System.out.println(abb.findMinArrowShots(points2));
		System.out.println("-------------------------------------------------------");
		
		int [][]points4= {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		System.out.println(abb.findMinArrowShots(points4));
		
	}
}
