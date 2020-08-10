package del;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class DenseRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int [] scores =  {295, 294, 291, 287, 287, 285, 285, 284, 283, 279, 277, 274, 274, 271, 270, 268, 268, 268, 264, 260, 259, 258, 257, 255, 252, 250, 244, 241, 240, 237, 236, 236, 231, 227, 227, 227, 226, 225, 224, 223, 216, 212, 200, 197, 196, 194, 193, 189, 188, 187, 183, 182, 178, 177, 173, 171, 169, 165, 143, 140, 137, 135, 133, 130, 130, 130, 128, 127, 122, 120, 116, 114, 113, 109, 106, 103, 99, 92, 85, 81, 69, 68, 63, 63, 63, 61, 57, 51, 47, 46, 38, 30, 28, 25, 22, 15, 14, 12, 6, 4};
//		int [] alice = {5, 5, 6, 14, 19, 20, 23, 25, 29, 29, 30, 30, 32, 37, 38, 38, 38, 41, 41, 44, 45, 45, 47, 59, 59, 62, 63, 65, 67, 69, 70, 72, 72, 76, 79, 82, 83, 90, 91, 92, 93, 98, 98, 100};
//		
		int [] scores = {100, 100, 50, 40, 40, 20, 10};
		int [] alice = {5, 25, 50, 120};
				
		
		int [] result = new int [alice.length];
		result = climbingLeaderboard (scores, alice);
		
		for (int z = 0; z<result.length; z++) {
			System.out.println (result[z]);
		}
		
	}
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int [] placement = new int [alice.length];
        int maxScore =-1, minScore = 1000000001;

        HashSet <Integer> ranks = new HashSet <Integer> ();
        int pos = 0;
        
        HashMap<Integer, Integer> calcResults = new HashMap< Integer, Integer>();

        for (int i = 0; i < scores.length; i++){
            ranks.add(scores[i]);
        }

        List<Integer> sortedList = new ArrayList<Integer>(ranks);
        Collections.sort(sortedList, Collections.reverseOrder());
        
        maxScore = sortedList.get(0);
        minScore = sortedList.get(sortedList.size() - 1);
        
        //List aliceList = Arrays.asList(alice);
        
        //aliceList.parallelStream().forEach(DenseRanking::populateRank);
        
        
        
        /*
        Stream.iterate(0, n -> n + 1)
        .limit(1_000_000)
        .parallel()   //with this 23s, without this 1m 10s
        .filter(Pyarelal::isPrime)
        .peek(x -> System.out.format("%s\t", x))
        */
        
        //employees.parallelStream().forEach(ParallelExample5::save); 

//        for (int j = 0; j < sortedList.size(); j++) {
//        	int curr = sortedList.get(j);
//        	if (maxScore < curr) maxScore = curr;
//        	if (minScore > curr) minScore = curr;
//        	System.out.println (sortedList.get(j));
//        }

        for (int i = 0; i < alice.length; i++) {
        	
        	if (calcResults.containsKey (alice[i]) ) {
        		placement[i] = calcResults.get(alice[i]);
        		continue;
        	}
        	
        	
        	if (alice[i] >= maxScore) {
        		placement[i] = 1;
        		continue;
        	}
        	
        	if (alice[i] == minScore) {
        		placement[i] = sortedList.size();
        		continue;
        	}
        	
        	if (alice[i] < minScore) {
        		placement[i] = sortedList.size() + 1;
        		continue;
        	}

            for (int j = 0; j < sortedList.size(); j++){
                pos++;
                if (alice[i] >= sortedList.get(j)) break; 
            }
            //pos++;
            
            calcResults.put(alice[i], pos);
            placement[i] = pos;
            pos = 0;

        }
         
        return placement;

    }
	
	
	
//	 int rank = 1;
//     int[] rankM = new int[scores.length];
//     rankM[0] = 1;
//     
//     for(int i = 1;i<scores.length;i++){
//         while(i<scores.length && scores[i] == scores[i-1]){
//             rankM[i] = rank;
//             i++;
//         }
//         rank++;
//         if(i < scores.length)
//             rankM[i] = rank;
//     }
//     int[] ans = new int[alice.length];
//     Integer[] sorted = Arrays.stream(scores).boxed().toArray(Integer[]::new);
//     for(int i=0;i<alice.length;i++){
//         int s = alice[i];
//         int pos = Arrays.binarySearch(sorted,s,(Integer a,Integer b)->{return b.compareTo(a);});
//         if(pos >= 0){
//             //System.out.println("For"+ s+" Pos "+pos+ " ran");
//             ans[i] = rankM[pos];
//         }
//         else{
//             int j = Math.abs(pos + 1);
//             if(j == 0)ans[i] = 1;
//             else ans[i] = rankM[j-1]+1;
//         }
//     }
//     return ans;
	
	static void populateRank (Object sc) {
		int scr = (int) sc;
		
	}
}



