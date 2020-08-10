package del;


class Pos {
	private int locX;
	private int locY;
	
	Pos () {
		
		this.locX = 0;
		this.locY = 0;
		
	}
	
	Pos (int x, int y){
		
		this.locX = x;
		this.locY = y;
		
	}
	
	public String toString () {
		return "" + this.locX + "" + this.locY;
	}
	
}

public class KnightsTour {

	/*
	Define the board - first cut n = 4: 4x4
	Define initial position for Knight - first cut, assume it is 0,0
	Define DataStructure for Path - String?
	Function to get list of next moves for the Knight
		returns a list of eight pairs of x and y coordinates
	Function to check if next move for Knight is within board
		returns true or false depending on whether x and y are within nxn
	Function to check if legal move in board is on a square that has not been visited on current tour
		returns true if it cannot find xy as concatenated string in path string
	Function to identify Path
		next moves from current position - get list of legal moves
		for each legal move	
			check if move is legal and unique - call functions defined to check
			if yes{
				update Path
				Check if all Squares have been visited - how do I do it? length of String to be 16x(2+whatever buffer I add to segregate the concat xys)
				if yes {
					print Path
				} else Call self with updated Path	
			} else continue
				
			}
		
	*/

	static int rows = 5; //length of rectangle
	static int cols = 3; //breadth of rectangle
	static int initLocX = 0; //init position
	static int initLocY = 0; //init position
	
	static String coveredPath = "";
	
	static void startWalk ( Pos currPos, String walkedSoFar) {
		if (walkedSoFar.length() > rows*cols*3) {
			System.out.println (walkedSoFar) ;
			return;
		} 
		
		Pos [] possibleMoves;
		possibleMoves = removeMovesPartOfCurrentPath(filterOutOfBoardMoves(getNextSet (currPos)));
		
		if (possibleMoves.length == 0) {
			System.out.println ("Terminating path at this point, board not completely traversed. Path walked so far: " + walkedSoFar) ;
		}
		
		for ( Pos nextPos : possibleMoves){
			startWalk ( nextPos, walkedSoFar + currPos.toString() );
		}
		
	}
	
	static Pos [] getNextSet ( Pos p){
		
		return new Pos [2];
		
	}
	
	static Pos [] filterOutOfBoardMoves (Pos [] n) {
		return new Pos [2];
	}

	static Pos [] removeMovesPartOfCurrentPath (Pos [] f) {
		return f;
	}
	
	public static void main (String [] v) {
		
		//String str = "1,2";
		//System.out.println (Integer.parseInt(str.split(",",0)[0]) +"" + Integer.parseInt(str.split(",",0)[1]));
		startWalk(new Pos(), ",");
		
		
	}
	
}