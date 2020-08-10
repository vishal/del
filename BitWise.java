package del;

public class BitWise {
	
	int countSetBits(int x) { 
        int count = 0; 
        while (x!= 0) { 
            x &= (x-1); 
            count++; 
        } 
        return count; 
	}
	
	public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        return ( (n!= 0) && ((n & n-1)== 0 ) ); 
    }

}
