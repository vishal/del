package del;

import java.util.HashMap;
import java.util.Random;

/*
 * Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9
 */
public class ContiguousSubArraySum {
	
	public static void main (String [] v ) {
		
		Random rand = new Random();
		int [] numsArr = new int[10];	
		for (int i = 0; i < 10; i++ ) {
			numsArr[i] = rand.nextInt(50);
		}

		//printArray (numsArr);
		int [] newNumsArr = {1, 2, 5, 4, 42, 7, 11, 23, 9, 10, 7, 6, 0, 11};
		
		findContiguousSubArraySum(numsArr , 42);
		
	}
	
	
	static void findContiguousSubArraySum (int [] arr, int k) {
		
		HashMap sumMap = new HashMap();
		int startOfArr = -1;
		int sum = 0;
		int endOfArr = -1;
		sumMap.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			sumMap.put(sum, i);
			endOfArr = i;
			System.out.println ("Sum so far: " + sum + " i = " + i + " and sum - k is " + (sum - k));
			if (sumMap.containsKey(sum - k) ){
				startOfArr = (int) sumMap.get(sum - k);
				break;
			}
			//System.out.println(startOfArr);
			
		}
		
		if (startOfArr == -1) return;
		
		System.out.println ("endOfArr - startOfArr" + endOfArr + " - " +  startOfArr);
		
		int [] resultArr = new int [endOfArr - startOfArr];
		for (int i = 0; i < resultArr.length; i++) {
			resultArr[i] = arr[endOfArr - i];
			//System.out.println(arr[startOfArr]);
		}
		
		System.out.println("Results below");
		printArray (resultArr);
	}
	
	static void printArray (int [] myarr) {
		
		for (int i = 0; i< myarr.length; i++) {
			System.out.println(myarr[i]);
		}
		
	}
	

}
