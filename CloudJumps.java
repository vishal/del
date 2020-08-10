package del;

//minimum number of hops to end. Avoid places with 1. Max jump is 2 elements

public class CloudJumps {
	
	public static void main (String [] v ) {
		int [] c = {0, 0, 1, 0, 0, 1, 0};
	    int [] wrkArr = new int [c.length];
	    wrkArr[0] = 0;
	    if (c[1] == 1) wrkArr[1] = 999;
	    if (c[1] == 0) wrkArr [1] = 1;
	    for (int i = 2; i< c.length; i++){
	        if (c[i] == 1) {
	            wrkArr [i] = 999;
	            continue;
	        } else {
	            wrkArr[i] = Math.min(wrkArr[i-1], wrkArr[i-2]) +1;
	            System.out.println("I can get to spot: " +i + " in "+ wrkArr[i] + " jumps.");
	        }
	        
	    }
	    
	    //System.out.println( wrkArr[c.length-1]);

	}

}
