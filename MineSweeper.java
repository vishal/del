package del;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	
	static int size = 10;
	static int mines = 10;

	public static void main (String [] v ) {
		
		int [][] layout = new int [size] [size];
		//int [][] layoutCopyForDisplay = new int [size] [size];
		initializeLayout (layout);
		printLayout (layout);
		
		startGame (layout);
		
	}

	private static void startGame(int[][] layout) {
		// TODO Auto-generated method stub
		
	}

	private static void initializeLayout(int[][] layout) {
		
		Random rand = new Random();
		//int [] numsArr = new int[10];	
		int minePos = 0;
		for (int i = 0; i < 10; i++ ) {
			minePos = rand.nextInt(100);
			
		}
		
	}

	private static void printLayout(int[][] layout) {

		for (int i = 0; i < size; i++ ) {
			for ( int j = 0; j< size; j++) {
				
				if (layout[i][j] == 0) System.out.print(""+i+""+j); 
				else System.out.print(layout[i][j]);
			}
			System.out.println ("");
		}
		
	}
}


//Scanner sc= new Scanner(System.in);      
//System.out.print("Enter first number- ");  
//int a= sc.nextInt();  
//System.out.print("Enter second number- ");  
//int b= sc.nextInt();  
//System.out.print("Enter third number- ");  
//int c= sc.nextInt();  

/*
 * 
float nextFloat()	It is used to scan the next token of the input as a float.
double nextDouble()	It is used to scan the next token of the input as a double.
byte nextByte()	It is used to scan the next token of the input as a byte.
String nextLine()	Advances this scanner past the current line.
boolean nextBoolean()	It is used to scan the next token of the input into a boolean value.
long nextLong()	It is used to scan the next token of the input as a long.
short nextShort()	It is used to scan the next token of the input as a Short.
BigInteger nextBigInteger()	It is used to scan the next token of the input as a BigInteger.
BigDecimal nextBigDecimal()	It is used to scan the next token of the input as a BigDecimal.

 */
