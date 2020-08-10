package del;
//https://leetcode.com/problems/jump-game-ii/

public class JumpGameII {
	public static void main (String [] v ) {
		
		int [] newnums = {1,0,1,1,4};
		System.out.println (canJump(newnums));
		
	}
	
	public static int canJump (int [] A) {
		int step = 0;
		int last = 0;
		int cur = 0;
		
		for (int i=0; i< A.length; i++) {
			
			if (i > last) {
				last = cur;
				System.out.println("last: " + last);
				step++;
				if (last >= A.length) return step; 
			}
			cur = Math.max(cur, i+A[i]);
			System.out.println("cur: " + cur);
		}
		
		return step;
	}


}

///*
// * public static int canJump(int[] nums) {
//		
//		int len = nums.length;
//        
//        int [] posArr = new int [len];
//        posArr[len-1] = 0;
//        for (int i = len - 2; i >= 0; i-- ) {
//        	//System.out.println ("len: " + len + " i: " + i );
//        	//System.out.println ( "i + nums[i] : " + i +" + "+ nums[i] );
//        	if ( i + nums[i] >= len -1 ) {
//        		System.out.println ("Can jump from position " + i + " to end directly.");
//        		posArr[i] = 1;
//        	} else {
//        		System.out.println ("Cannot jump from position " + i + " to end, hence checking if there is a path");
//        		posArr[i] = 10000000;
//        		//System.out.println("Setting value of current position ")
//        		//System.out.println ("Cannot jump from position " + i + " to end, hence checking if there is a path");
//        		for (int z = 1; z <= nums[i]; z++) {
//        			System.out.println("checking position" + i+z );
//        			if (posArr[i+z] < 10000000) {
//        				posArr[i] = Math.min (posArr[i], posArr[i+z]);
//        				System.out.println ("There is a path using " + posArr[i] + " jumps");
//        				//break;
//        			}
//        			
//                    //posArr[i] = 10000000;
//        		}
//        		
//        		posArr[i]++;
//        		
//        	}
//        		
//        	//System.out.println ("posArr[i]; " + posArr[i]);
//	    }
//        
//        //for (int i = 0; i < posArr.length; i++) System.out.println (posArr[i]);
//        
//        return posArr[0];
//      
//	}
// */
//
///*
// * 
// * public int jump(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return  0;
//        }
//        
//        int steps = 0;
//        int i = 0;
//        while (i<nums.length-1) {
//            steps++;
//            i = findNextStep(nums, i);
//        }
//        
//        return steps;
//    }
//    
//    private int findNextStep(int[] nums, int i) {
//        int reachable = nums[i] + i;
//        if (reachable >= nums.length - 1) {
//            return nums.length-1;
//        }
//        int next = reachable;
//        int max = reachable;
//        for (int j=i+1; j<=reachable && j < nums.length-1; j++) {
//            if ((nums[j] + j) > max) {
//                max = nums[j] + j;
//                next = j;
//            }
//        }
//        return next;
//    }
// */
//*/