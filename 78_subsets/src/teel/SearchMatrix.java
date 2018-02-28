package teel;

public class SearchMatrix {
	 private boolean binarySearch(int []arr, int start, int end, int target)
	 {
		 if (arr.length == 0) return false;
		 if (arr.length == 1) return (target == arr[0]);
		 while(start <= end) {
			 int mid = start + (end - start)/2;
			 if (target == arr[mid]) {
				 return true;
			 }
			 if (target < arr[mid]) {
				 end = mid - 1;
			 } else {
				 start = mid+1;
			 }
		 }
		 return false;
	 }
	 
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if (matrix.length == 0) { 
			 return false;
		 }
		 
		 int start = 0, end = (matrix[0].length * matrix.length)-1;
		 
		 while(start <= end) {
			 int mid = start + (end - start)/2;
			 int x = mid / matrix[0].length;
			 int y = mid % matrix[0].length;
			 
			 if (target == matrix[x][y]) {
				 return true;
			 }
			 if (target < matrix[x][y]) {
				 end = mid - 1;
			 } else {
				 start = mid+1;
			 }
		 }
		 return false;
	 }
	 
	 public static void main(String []args)
		{
		 SearchMatrix smz = new SearchMatrix();
			//int [][]matrix = {{0,1}};
			int  [][]matrix = {{1} ,{510}};
			System.out.println(smz.searchMatrix(matrix, 510));
		}
}
