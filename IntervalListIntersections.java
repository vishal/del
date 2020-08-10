package del;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */



public class IntervalListIntersections {

	public static void main (String [] v ) {
//		int [] [] A = { {0,2}, {5,10}, {13,23}, {24,25} }; 
//		int [] [] B = { {1,5}, {8,12}, {15,24}, {25,26} };
		
		int [] [] A = { {1,3}, {5,9} }; 
		int [] [] B = { };
		
		/*[[1,3],[5,9]]
[]
*/
		int [] [] C = intervalIntersection (A, B);
		
		for (int i = 0; i < C.length; i++ ) {
			for (int j = 0; j < C[0].length; j++ ) {
				System.out.print (C[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
        
		int a = A.length;
		int b = B.length;
		
		int len = ( a < b ) ? a : b;
		int res = ( a > b ) ? a : b;
		int runningVarA = 0;
		int runningVarB = 0;
		
		//int [] [] result = new int [res] [2];
		ArrayList <int [] > result = new ArrayList < int [] > ();
		
		
		while (runningVarA < a && runningVarB < b) {
			
			
			if ( A[runningVarA][0] <= B[runningVarB][1] ) {
				int [] interv = new int [2];
				interv[0] = Math.max ( A[runningVarA][0] , B[runningVarB][0] );
				interv[1] = Math.min ( A[runningVarA][1] , B[runningVarB][1] );
				result.add(interv);
				if ( ( runningVarB + 1 < b ) && A[runningVarA][1] < B[runningVarB + 1][0]) {
					runningVarA++;
				} else runningVarB++;
				
			} else runningVarB++;
			
			
			
		}
		
		if (res > len ) {
			
			System.out.println ("res: " + res + " len: " + len);
			for (int j = len; j <res; j++) {
				int [] empty = {};
				result.add(empty);
			}
		}
		
		System.out.println (result.size());
		
		int [] [] ret = new int [result.size()][2];
		
		for (int i = 0; i < ret.length; i++) ret[i] = result.get(i);
		
		//return (int[][]) result.toArray();
		
		return ret;
		
    }


}



/*
 * 
 *     public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length, n = B.length, i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        
        while (i < m && j < n) {
            int[] a = A[i], b = B[j], c = intersect(a, b);            
            if (c[1] >= c[0]) res.add(c);
            if (a[1] <= c[1]) i++;
            if (b[1] <= c[1]) j++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
    
    private int[] intersect(int[] a, int[] b) {
        return new int[] {Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
 * 
 */
*/