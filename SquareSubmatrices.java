package del;

//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
//  Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

/*
 * 
 * 
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
 * 
 * 
 * 
 */

public class SquareSubmatrices {

	public static void main(String[] args) {

		int [] [] arr = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		
		
		System.out.println (countSquares (arr) );

	}
	
	public static int countSquares(int[][] matrix) {
		
		if (matrix == null) return -1;
		if (matrix.length == 1) return matrix[0][0];
	
		int res = 0;
		int [] [] workArr = new int [matrix.length][matrix[0].length];
		
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++ ) {
				
				workArr [i][j] = 0;

				if (matrix [i][j] == 1) {
				
					int left = (j-1 < 0) ? 0 : workArr [i][j-1];
					int top = (i-1 < 0) ? 0 : workArr[i-1][j];
					int diag = (j-1 < 0 || i-1 < 0) ? 0 : workArr[i-1][j-1];
					
					//if (i ==2 && j == 3) System.out.println (left + " " + top + " " + diag);
					
					workArr [i][j] = Math.min ( Math.min(left, top), diag ) + 1;
					
					
				}
				
				//System.out.println ("i: " + i + "j: " + j + "val: " + workArr [i][j] );
				
				res = res + workArr[i][j];
				
			}
		}
		
		return res;
		
	}
	

}
