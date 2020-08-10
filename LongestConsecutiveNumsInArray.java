package del;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveNumsInArray {
	
	public static void main (String [] v ) {
		
		int [] numsArr = new int [500];
		
		Random rand = new Random();
		
		for (int i = 0; i < 500; i++ ) {
			numsArr[i] = rand.nextInt(500);
		}
		
		findLongestConsecutiveSeq (numsArr);
		
		
	}
	
	static void findLongestConsecutiveSeq (int [] arr) {
		
		HashMap<String, Integer> map = new HashMap<>(); 
		HashSet<String> set=new HashSet<String>();
		
	}
	
}

