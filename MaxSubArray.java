package del;

public class MaxSubArray {

    public int maxSubarraySumCircular(int[] A) {
        
        if(A.length == 0) return 0;
        if (A.length==1) return A[0];
        int sum = A[0];
        int maxSoFar = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];
        int minSoFar = A[0];
        for(int i = 1; i < A.length; i++){
            int num = A[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);
            
            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);
            
            sum += num;
        }
        if(sum == minTotal) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
    }
    
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxsum = nums[0];;
        int d = maxsum;
        for (int i = 1; i< nums.length; i++ ){
            d = Math.max (d + nums[i], nums[i]);
            if(maxsum < d) maxsum = d;
        }
        return maxsum;
        
    }

	
}

/*
 * Also Kadane's
 * 
 * def Sum1(a): 

    maxsum = 0
    d = 0
    
    for e in range(0,len(a)): 
        d = d + a[e]
        
        if d <= 0: 
            d = 0
         
        elif (maxsum < d): 
            maxsum = d
         
    return maxsum

array = []

import random
for l in range(0,11):
    k = random.randint(-10,10)
    array.append(k)
print("This is the Array: ",array)
print("This is the greatest sum of the terms of a subarray in the array: ",Sum1(array))   

 * */
