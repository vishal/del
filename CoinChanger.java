package del;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CoinChanger {

	public static void main(String[] args) {

		List <Integer> c = new ArrayList <Integer> (3);
		c.add(1);
		c.add(2);
		c.add(3);
		//c.add(5);
		//c.add(7);
		
		System.out.println (getWays (4, c) );
		
		/*
		 *   	0	1	2	3	4	5	6	7	8	9
		 *   1	1	1	1	1	1	1	1	1	1	1
		 * 	 2	1	1	2	2	3	3	4	4	5	5
		 *   3	1	1	2	3	4	5	7	7	9	9
		 *   5	1	1	2	3	4	6	6	9	12	13
		 *   7	1	1	2	3	4	6	6	10	13	15
		 *   
		 */

	}
	
	public static long getWays(int n, List<Integer> c) {
        
		long [] [] dpArray = new long [c.size()][n+1];
        //long result = 0l;
		//long temp = 0l;
		//List <Integer> cSharp = c.sort(Comparator.naturalOrder());

        for (int i = 0; i < c.size(); i++) {
        	
        	dpArray [i][0] = 1; // only 1 way to give out change for 0 amount, give nothing.
        	
        }
        
        for (int j = 1; j < n+1; j++) {
    		
    		if  (j % c.get(0) == 0) dpArray [0][j] = 1 ;
    		else dpArray [0][j] = 0; 
        }
        
        for (int i = 1; i < c.size(); i++) {
        	
        	for (int j = 1; j < n+1; j++) {
        		
        		if  ( (c.get(i) > j) ) {
        			dpArray [i][j] = dpArray [i-1][j];
        		}
        		else {
        			 
        			dpArray [i][j] = dpArray [i-1][j] + dpArray [i][j-c.get(i)];
        			//temp = 0l;
        		}
    
        	}
            
        }
        
        return dpArray[c.size()-1][n];
        
	}
	
	public int betterChange(int amount, int[] coins) {

	    int dp[] = new int[amount+1];
	    Arrays.fill(dp, 0);
	    dp[0] = 1;
	    for(int coin:coins)
	    {
	        for(int j = coin; j<=amount; j++){
	        dp[j] += dp[j - coin];
	        }
	    }
	        return dp[amount];
	}

}



