package del;
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

public class FloodFill {
	//[[0,0,0],[1,1,1]]
	public static void main (String [] v) {
		
		int [] [] image = {{0,0,0},{1,1,1}};
		int row = image.length;
        int col = image[0].length;
        floodFill (image,1,1,5);
		for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		System.out.println (image[i][j]);
        	}
        }
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		//if (image[sr][sc] == -1) return image;
        
        int row = image.length;
        int col = image[0].length;
        //int [] [] newImage = new int [row][col];
        int currColor = image[sr][sc];
        //if (image[sr][sc] == -1) return image;
        image[sr][sc] = -1;
        if ( (sr + 1 < row) && (image[sr+1][sc] == currColor && image[sr+1][sc] != -1) ) floodFill (image, sr+1, sc);
        if ( (sr - 1 >= 0) && (image[sr-1][sc] == currColor && image[sr-1][sc] != -1) ) floodFill (image, sr-1, sc);
        if ( (sc + 1 < col) && (image[sr][sc+1] == currColor && image[sr][sc+1] != -1) ) floodFill (image, sr, sc+1);
        if ( (sc - 1 >= 0) && (image[sr][sc-1] == currColor && image[sr][sc-1] != -1 ) ) floodFill (image, sr, sc-1);
        
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (image[i][j] == -1) image[i][j] = newColor;
        	}
        }
        
        return image;
        
    }
	
	public static int[][] floodFill(int[][] image, int sr, int sc) {

		int row = image.length;
        int col = image[0].length;
        //int [] [] newImage = new int [row][col];
        int currColor = image[sr][sc];
        //if (image[sr][sc] == -1) return image;
        image[sr][sc] = -1;
        if ( (sr + 1 < row) && (image[sr+1][sc] == currColor && image[sr+1][sc] != -1) ) floodFill (image, sr+1, sc);
        if ( (sr - 1 >= 0) && (image[sr-1][sc] == currColor && image[sr-1][sc] != -1) ) floodFill (image, sr-1, sc);
        if ( (sc + 1 < col) && (image[sr][sc+1] == currColor && image[sr][sc+1] != -1) ) floodFill (image, sr, sc+1);
        if ( (sc - 1 >= 0) && (image[sr][sc-1] == currColor && image[sr][sc-1] != -1 ) ) floodFill (image, sr, sc-1);
        
//        for (int i = 0; i < row; i++) {
//        	for (int j = 0; j < col; j++) {
//        		if (image[i][j] == -1) image[i][j] = newColor;
//        	}
//        }
        
        return image;
	}
        
}
