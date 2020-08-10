package del;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//https://leetcode.com/problems/two-city-scheduling/

public class TwoCityScheduling {

	public static int twoCitySchedCost(int[][] costs) {
        
		int result = 0;
		
		//HashMap <Integer, Integer> costDiff = new HashMap <String, Integer> ();
		int [] [] costsDiff = new int [costs.length][2];
		int countOfZero = 0;
		int countOfOne = 0;
		
		for (int i = 0; i < costs.length; i++ ) {
			
			if (costs[i][0] > costs [i][1] ) {
				costsDiff [i][0] = i;
				costsDiff [i][1] = costs[i][0] - costs[i][1];
				//countOfOne++;
			} else {
				costsDiff [i][0] = i;
				costsDiff [i][1] = costs[i][1] - costs[i][0];
				//countOfZero++;
			}
			
		}
		
		Arrays.sort(costsDiff, new Comparator<int[]>() { 
	          public int compare(final int[] entry1, final int[] entry2) { 
	        	  if (entry1[1] < entry2[1]) return 1; 
	        	  else return -1; 
	          } 
		});
		
		for (int i = 0; i < costsDiff.length; i ++ ) {
			System.out.println (costsDiff[i][0] + " " + costsDiff [i][1]);
			int which = 0;
			if (costs[costsDiff[i][0]] [0] > costs[costsDiff[i][0]] [1]) which = 1;
			if (countOfOne ==  costsDiff.length/2) which = 0;
			if (countOfZero ==  costsDiff.length/2) which = 1;
			result = costs[costsDiff[i][0]][ which] + result;
			if (which == 0) countOfZero++;
			else countOfOne++;
		}
		
		
		
		return result;
		
    }
	
	public static void main (String [] v ) {
		
		//int [] [] tripCosts = { {10,20}, {30,200}, {400,50}, {30,20} };
		int [] [] tripCosts = { {259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469} };
		
		System.out.println (twoCitySchedCost (tripCosts));
		
		
	}

	public int twoCitySchedCostBetter(int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        
        int n = costs.length/2;
        
        for(int i = 0; i<n; ++i) {
           
            total += costs[i][0] + costs[i+n][1];
        }
                

        return total;
        
    }	
	
}



