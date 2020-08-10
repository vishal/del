package del;
//https://leetcode.com/problems/candy/


public class Candy {

	public static void main(String[] args) {
		int [] q = {1, 2, 1, 3, 5, 6, 4, 3, 1, 0};
		System.out.println (candy (q));

	}

	private static int candy(int[] q) {

		if (q == null || q.length == 0) return 0;
		if (q.length == 1 ) return 1;
		
		int res = 0;
		int [] r = new int [q.length];
		
//		if (q[0] <)
//		
//		for (int i = 1; i < q.length-1; i++ ) {
//			if (q[i-1] < q[i]) {
//				r[i-1]
//			}
//		}
		
		return res;
	}

}
