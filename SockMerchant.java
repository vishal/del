package del;

public class SockMerchant {

	public static void main (String [] v ) {
		
		int [] ar = { 1, 2, 3, 4, 1, 2, 3, 5,1 ,1 ,2 ,4 , 5, 6};
		int[] workingArr = new int[100];
		int result = 0;
		
		for (int i = 0; i < ar.length; i ++) {
			
			workingArr[ar[i]]++;
			
		}
		
		for (int i = 0; i < workingArr.length; i++) {
			result = result + workingArr[i]/2;
		}
		
		System.out.println (result);
		
	}
	
}
