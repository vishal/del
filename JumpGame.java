package del;

//https://leetcode.com/problems/jump-game/

public class JumpGame {
	
	public static void main (String [] v ) {
		
		//int [] nums = {3,2,1,0,4};
		//System.out.println (canJump(nums));
		int [] newnums = {1,2,3};
		System.out.println (canJump(newnums));
		
	}
	
	public static boolean canJump(int[] nums) {
		
		int len = nums.length;
        
        boolean [] posArr = new boolean [len];
        
        for (int i = len - 1; i >= 0; i-- ) {
        	//System.out.println ("len: " + len + " i: " + i );
        	//System.out.println ( i + nums[i] );
        	if ( i + nums[i] >= len -1 ) {
        		posArr[i] = true;
        	} else {
        		posArr[i] = false;
        		for (int z = 0; z <= nums[i]; z++) {
        			if (posArr[i+z]) {
        				posArr[i] = true;
        				break;
        			}
        		}
        		
        	}
        		
        	System.out.println ("posArr[i]; " + posArr[i]);
	}
        
        return posArr[0];
        
    }

}
