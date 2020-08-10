package del;

public class RepeatedChars {

	public static void main (String [] v ) {
	
		System.out.println (repeatedString ("cfimaakj", 554045874191l));
		
	}
	
	static long repeatedString(String s, long n) {

        long repeats = 0l;
        int numOfAInS = 0;
        int numOfAInPartial = 0;
        long part = n % s.length();
                
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='a') {
                numOfAInS++;
                if (i < part) numOfAInPartial++;
            }
            
            repeats = numOfAInPartial + ((n)/s.length())*numOfAInS;
        }
        
        return repeats;
        
	}
	
}
