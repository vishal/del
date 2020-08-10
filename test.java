package del;

import java.util.HashSet;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		// 
//		double frac = (1.0*1)/2;
//		System.out.println ((int)Math.round(0.5));
//		System.out.println (frac);
//		System.out.println ((int)Math.round(frac);
		
		//numberOfOnesInNum (105);
		
		//System.out.println(findJudge(3, new int [] [] {{1,2},{2,3}}) );
		
		System.out.println (gameWithCells (1,1));

		
		
	}
	
	static int gameWithCells(int n, int m) {
        
        int fours = 0;
        int twos = 0;
        int solo = 0;

        fours = (n/2) * (m/2);
        System.out.println (fours);
        twos = ((n%2)*m ) / 2 + ((m%2)*n ) / 2;
        System.out.println(twos);
        if (twos == 0) return fours;
        solo = n*m - fours*4 - twos*2;
        System.out.println(solo);
        

        return ( fours + twos + solo);

    }
	
	public static int findJudge(int N, int[][] trust) {
        
		HashSet <Integer> numSet = new HashSet <Integer> ();
		HashSet <Integer> trustingSet = new HashSet <Integer> ();
        
        
        for (int i = 1; i < N+1; i++) numSet.add(i);
        
        for (int i = 0; i < trust.length; i++){
            numSet.remove(trust[i][0]);
            //trustingSet.add(trust[i][0]);
        }
        
        System.out.println (trust.length);
        System.out.println (numSet.size());
        System.out.println (trustingSet.size());
        
        if (numSet.size() != 1) return -1;
        
        Iterator<Integer> num = numSet.iterator(); 
        if(!num.hasNext()) return -1;
        int trusted = num.next();
        
        for (int i = 0; i < trust.length; i++) {
        	if(trust[i][1] == trusted) trustingSet.add(trust[i][0]);
        }
        
        if (trustingSet.size() < N-1) return -1;
        return num.next();
        
    }
	
	
	/* Best findJudge
	 * 
	 * if(trust.length<  N-1){
            return -1;
        }
        
        int [] inEdges = new int[N+1];
        int [] outEdges =new int[N+1];
        for(int[] relation :trust){
            outEdges[relation[0]]++;
            inEdges[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
        if (inEdges[i] == N - 1 && outEdges[i] == 0) {
            return i;
        }
    }
        return -1;
       
    }
	 * */
	 
	
	// first unique character
	public int firstUniqChar(String s) {
		int min=Integer.MAX_VALUE;
		for(char i='a';i<='z';i++) {
			int pos=s.indexOf(i);
			if(pos!=-1 && pos==s.lastIndexOf(i)) min=Math.min(min,pos);
		}
		return min==Integer.MAX_VALUE?-1:min;
	}
	
	//majority element in an array
	public int majorityElement(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return majorityElement(nums, 0);
    }
    
	private int majorityElement(int[] nums, int start){
        int count = 1;
        int num = nums[start];
        for(int i = start+1;i<nums.length;i++){
            if(num == nums[i]) count++;
            else count--;
            if(count == 0) return majorityElement(nums,i+1);
        }
        return num;
    }
    //both functions above are for majority element problem
	
	
	
	//find complement of a number
	 public int findComplement(int num) {
	        int result = 0;
	        //use set to set the value of result in each bit
	        int set = 1;
	        while(num != 0) {
	            //if last bit is 0 , set corresponding position of result to 1
	            if((num&1)== 0) {
	                result |= set;
	            }
	            //if last bit of num is 1, then do not need to set result
	            set <<= 1; // left shift 1 bit
	            num >>= 1;//right shift num, move right 1 bit
	        }
	        return result;
	    }
	
	//can create ransom note from magazine
	public boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int[] caps = new int[26];
        for (char c : ransom.toCharArray()) {
        	int index = magazine.indexOf(c, caps[c - 'a']);
        	if (index == -1) return false;
        	caps[c - 'a'] = index + 1;
        }
        return true;
	}
	
	// returns number in array that appears only once when every other element appears twice
	public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
        
    }
	
	
	//stub method to support BinSearch function
	static boolean isBadVersion (int n) {
		return true;
	}
	
	// logic for binary search :$
	
	static int BinSearch ( int n) {
		int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
	}
	
	static void saySomething (int n) {
		int num = 0;
		int mask = 0B01000000000000000000000000000000;
		boolean flag = false;
		System.out.println(mask);
		for (int i = 30; i >= 0; i-- ) {
			if ((n & mask) > 0) {
				System.out.println (i);
				flag = true;
			}
			if (flag && (n & mask) <= 0) {
				num = num + (int) Math.pow(2, i);
			}
			mask = mask >> 1;
		}
		
		System.out.println ("Num is: " + num );
		
	}
	
	static void numberOfOnesInNum (int a) {
		//int a = 3;
	    int orig = a;
	    int count = 0;
	    while ( a > 0 ){
	    	a = a >> 1 << 1;
		    if ( orig-a == 1 ) count++;
		    orig = a >> 1;
		    a = orig;
	    }

		System.out.println("Number of 1s are: "+count);
	}

}
	