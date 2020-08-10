package del;

public class TowersOfHanoi {
	
	static int n = 0;
	
	static void moveTower( int h, String fromPole, String toPole, String withPole) {
	    if ( h >= 1) {
	        moveTower(h-1,fromPole,withPole,toPole);
	        moveDisk(fromPole,toPole);
	        moveTower(h-1,withPole,toPole,fromPole);
	    }
	}

	static void moveDisk(String fp, String tp) {
	    System.out.println("moving disk from " + fp + " to " + tp);
	    n++;
	}

	public static void main (String [] v ) {
		moveTower(10,"A","B","C");
		System.out.println ("Total moves: " + n);
	}

}
