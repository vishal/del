package del;

import java.util.List;

public class SumOfDiagonals {
	
	public static int diagonalDifference(List<List<Integer>> arr) {
	    // Write your code here
	        int n = arr.size();
	        int diff = 0;
	        int sumOfxEqyDiagonal = 0;
	        int sumOfxplusyEqnDiagonal = 0;

	        for (int i = 0; i <n; i++) {
	            
	            sumOfxEqyDiagonal = sumOfxEqyDiagonal + arr.get(i).get(i);
	            sumOfxplusyEqnDiagonal = sumOfxplusyEqnDiagonal + arr.get(i).get(n-i-1);
	            
	        }

	        diff = Math.abs(sumOfxplusyEqnDiagonal - sumOfxEqyDiagonal);
	        return diff;

    }


}
