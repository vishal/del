package del;

//Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
//You can modify the input array in-place.
//https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		int dummy = 0;
        
		for (int i = 0; i < n; ){
            if (nums[i] > n || nums[i] <= 0) {
            	i++;
            	continue;
            }
			if (nums[i] != i+1 && nums[i]!= nums[nums[i]-1]) {
                dummy = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
                nums[i] = dummy;
                
			} else i++;
        }
		
		for (int i = 0; i < n; i++) {
			//System.out.println(nums[i]);
			if(nums[i] != i+1) return i+1;
		}
		
		return n+1;
		
    }
	
	public static void main (String [] v ) {
		int [] nums = {1, 1};
		System.out.println(firstMissingPositive(nums));
	}
}
