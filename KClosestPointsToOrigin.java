package del;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	public static int[][] kClosest(int[][] points, int K) {
		System.out.println("here");
		if (K==0) return null;
		if (K >= points.length) return points;
		
        int [] [] closestPoints = new int [K][2];
        PriorityQueue<int []> prq = new PriorityQueue<int []>(distComparator);
        
        for (int i = 0; i < points.length; i++) {
        	
        	prq.add(points[i]);
        	
        }
		
        prq.forEach(KClosestPointsToOrigin::printArr);
		
        System.out.println("here after adding to prq");
        for (int i =0; i < K; i++) {
        	closestPoints[i] = prq.poll();
        	System.out.println(closestPoints[i][0] + " " + closestPoints[i][1]);
        }
        
        return closestPoints;
    }
	
	public static void printArr (int [] ar) {
		System.out.println ("x; " + ar[0] + " y: " + ar[1]);
	}
	
	public static Comparator<int [] > distComparator = new Comparator<int []>(){
		
		@Override
		public int compare(int [] ar1, int [] ar2) {
			double d1 = Math.sqrt(ar1[0]*ar1[0] + ar1[1]*ar1[1]);
			double d2 = Math.sqrt(ar2[0]*ar2[0] + ar2[1]*ar2[1]);
			System.out.println( "d1: " + d1 + " d2: " + d2 + " diff: " + ( (d1 - d2)));
			int diff = 0;
			if (d1 > d2) diff = 1;
			else diff = -1;
            return diff;
        }
	};
	
	public static void main (String [] v ) {
		int [] [] dot = {{1,3},{-2,2}};
		kClosest ( dot, 1);
	}
	
}



///*
// * 
// * 
// * class Solution {
//    public int[][] kClosest(int[][] points, int K) {
//       int N = points.length;
//        int[] distance = new int[N];
//        
//        //Fill in all the squared distances for each inout point
//        for (int i = 0; i < N; ++i)
//            distance[i] = calculatedistance(points[i]);
//
//        //Sort the calculated square distances
//        Arrays.sort(distance);
//        
//        // get only K or less than K distance
//        int distK = distance[K-1];
//
//        int[][] ans = new int[K][2];
//        int t = 0;
//        
//        // Iterate over input list again and get only K values and store it in result.
//        for (int i = 0; i < N; ++i)
//            if (calculatedistance(points[i]) <= distK)
//                ans[t++] = points[i];
//        return ans;
//    }
//
//    public int calculatedistance(int[] point) {
//        return point[0] * point[0] + point[1] * point[1];
//    }
//
//}
// */
//*/