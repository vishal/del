package del;

import java.util.Arrays;
import java.util.Random;

//You are given a sorted array consisting of only integers where every element appears exactly twice, 
//except for one element which appears exactly once. Find this single element that appears only once.
//Your solution should run in O(log n) time and O(1) space.

public class SingleInSortedArray {
	
	public static void main (String [] v) {
		//int [] arr1 = {1,1,2,3,3,4,4,8,8};
		//int [] arr1 = {1,1,2};
		//int [] arr2 = {3,3,7,7,10,11,11};
		int [] arr3 = {0,1,1,2,2,5,5};//{1,1,2,3,3,4,4,8,8};
		int arr4[] = new int [2000];
		
		Random rand = new Random();
		
		for (int i = 0; i < 999; i++ ) {
			arr4[i] = rand.nextInt(999);
			arr4[i+1] = rand.nextInt(999);
		}
		arr4[1999] = 1000;
		Arrays.sort(arr4);
		
		System.out.println (/*singleNonDuplicate(arr1) + " " +*/ singleNonDuplicate(arr4));
	}
	
	public static int singleNonDuplicate (int [] nums) {
		if (nums.length == 1) return nums[0];
		return worker (nums, 0, nums.length-1);
	}
	
	public static int worker (int [] nums, int st, int end) {
		
		System.out.println(st + " " + end);
		if (st == end) return nums[st];
		int n = end - st + 1;
		
		if (n == 3 ) {
			if (nums [st] == nums[st+1]) return nums[st+2];
			if (nums[st+1] == nums[st+2]) return nums[st];
		}
		
		//n++;
		int m = st + n/2;
		
		System.out.println ("Value of n is: " + n + " and value of m is: "+ m);
		if (nums[m] !=nums[m-1] && nums[m] != nums[m+1]) return nums[m];
		
		if (m%2 == 0) {
			if (nums[m]==nums[m-1]) {
				return worker (nums, st, m-2);
			} else {
				return worker (nums, m+2, end);
			}
		} else {
			if (nums[m]==nums[m-1]) {
				return worker (nums, m+1, end);
			} else {
				return worker (nums, st, m-1);
			}
		}
		
	}
	
	/*
	 * public int singleNonDuplicate(int[] nums) {
        int lo = 0, len = nums.length, hi = len / 2;

        while (lo < hi){
            int mid = lo + ((hi - lo) >> 1);
            if (nums[2 * mid] == nums[2 * mid + 1]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[2 * lo];

    }
	 * */
	 */

}
