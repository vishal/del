package del;

import java.util.Arrays;

public class ContiguousBinaryArrayOfZeroSum {

	public static int findMaxLength(int[] nums) {
		int result = 0;
		//System.out.println ("Function called");
		if (nums.length == 0 || nums == null) return result;
		
		int [] workArr = new int [nums.length];
		workArr[0] = (nums[0]== 0) ? -1 : nums[0];
		for (int i = 1; i < nums.length; i++) {
			
			workArr[i] = workArr[i-1] + ((nums[i]== 0) ? -1 : nums[i] );
			//System.out.println(workArr[i]);
			
		}
		
		//Arrays.sort(workArr);
		int j = workArr.length-1;
		for (int i = 0 ; i < workArr.length; i++) {
			System.out.println(workArr[i]);
			if (workArr[i] + workArr[j] == 0) return  (j-i);
			j--;
			if (i == j) break;
		}
		
        return result;
    }
	
	public static void main (String [] v ) {
		
		int [] arr = {0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0 ,0 ,0, 0, 0, 0};
		System.out.println(findMaxLength(arr));
	}

}



/*
 * public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        int maxLength = 0;
        int[] arr = new int[2*nums.length+1];
        for( int i = 0; i < arr.length; i++) arr[i] = -2;
        arr[nums.length]=-1;
        int counter = nums.length;
        for(int i = 0; i < nums.length; i++){
            counter+=nums[i]*2-1;
            if(arr[counter] == -2){
                arr[counter] = i;
            }else{
                maxLength = Math.max(maxLength, i-arr[counter]);
            }                
        }
        return maxLength;
    }
 */
*/