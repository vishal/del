
package del;

public class MinimumBribes {
	
	public static void main (String [] v ) {
		//1 2 5 3 7 8 6 4
		int [] q = {1, 2, 5, 3, 7, 8, 6, 4};
		minimumBribes(q);
		
		int [] p = ArrayCopy (q);
		System.out.println(getInvCount (p) );
		
	}
	
	static int getInvCount(int [] p) { 
        int inv_count = 0; 
        int n = p.length;
        for (int i = 0; i < n - 1; i++) 
            for (int j = i + 1; j < n; j++) 
                if (p[i] > p[j]) 
                    inv_count++; 
  
        return inv_count; 
    } 
	
	static int [] ArrayCopy (int [] source) {
		int [] copy = new int [source.length];
		
		for (int i = 0; i < source.length; i++) {
			copy[i] = source[i];
		}
		
		return copy;
	}
	
	static void minimumBribes(int[] q) {

        //System.out.println ("method called");
        
        String cantBeDone = "Too chaotic";
        int result = 0;

        for (int i = 0; i < q.length; i++) {
            if (q[i] > i+3){
                System.out.println(cantBeDone);
                return;
            } else {
                if (q[i]<=i) {
                    //if () result++;
                    continue;

                }
                //System.out.println ("Item at position: " + i + " is: " +q[i]+ " which needed " + (q[i] - i-1) + " bribes." );
                result = result + q[i] - i-1;
            }
        }

        System.out.println(result);

    }

}
