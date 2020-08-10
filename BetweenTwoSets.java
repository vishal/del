package del;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/between-two-sets/problem

public class BetweenTwoSets {
	
	static int gcd(int a, int b) { 
	    if (a == 0) return b;  
	    return gcd(b % a, a);  
    } 
	
	static int lcm(int a, int b){ 
        return (a*b)/gcd(a, b); 
    } 
	
	static int findGCF (int x, int y) {
        //int gcf = x;
        int diff = 0;

        if (x == y) return x;
        if (x > y) {
            diff = x-y;
            if (x%y ==0) return y;
        } else {
            diff = y - x;
            if (y%x==0) return x;
        }

        //System.out.println("Diff: "+ diff);

        for (int i = diff; i > 0; i--) {
        	//System.out.println(i);
            if (x%i == 0 && y%i ==0) return i; 
        }
        //System.out.println("Diff: "+ diff);
        return 1;
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    
    int result = 0;
    int maxA = 0;
    int lcmA = 1;
    int minB = 101;
    int gcfB = 1;

    //int [] myPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, }

    for (int i = 0; i < a.size(); i++){

        if (maxA < a.get(i)) maxA = a.get(i);
        //find LCM of list a
        lcmA = lcm (lcmA, a.get(i));

    }

    System.out.println ("LCM of A: "+ lcmA);
    gcfB = b.get(0);
    for (int j = 0; j < b.size(); j++) {

        if (minB > b.get(j) ) minB = b.get(j);
        gcfB = findGCF (gcfB, b.get(j));
        
    }

    System.out.println ("GCF of B: "+ gcfB);

    for ( int i = lcmA; i < gcfB + 1; i++) {
        if (  (i%lcmA == 0 )&& (gcfB % i == 0 ) ) result++;
    }

    return result;

    }
    
    public static void main (String [] v ) {
    
    	System.out.println (findGCF(72, 36));
    	//System.out.println(findGCF(12, findGCF(20, 30) ) );
    	//getTotalX
    	
    	List <Integer> b  = new ArrayList <Integer>(2);
    	List <Integer> a  = new ArrayList <Integer>(3);
    	
    	a.add( 3);
    	a.add( 9);
    	a.add( 6);
    	
    	b.add( 36);
    	b.add( 72);
    	System.out.println(getTotalX(a,b));
    	
    
    }
}
