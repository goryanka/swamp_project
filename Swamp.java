import java.io.*;
import java.util.*;

// DO NOT!! IMPORT JAVA.LANG

public class Swamp
{
	static int[][] swamp;  // NOW YOU DON'T HAVE PASS THE REF IN/OUT METHODS

 	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];
		String path = ""; // with each step grows to => "[2,3][3,4][3,5][4,6]" etc
		dfs( row, col, path );
	} // END MAIN

 	
	// --YOU-- WRITE THIS METHOD (LOOK AT PRINTSWAMP FOR CLUES)
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		
		// OPEN UP A SCANNER USING THE INCOMING FILENAME
		File inFile = new File(infileName);
		Scanner inputFile = new Scanner(inFile);
		int rowCol = inputFile.nextInt();
		// THE FIRST NUMBER ON THE FIRST LINE WILL BE THE NUMBER OF ROWS & COLS
		// THE SECOND & THIRD NUMBER ON 1st LINE WILL BE THE DROP IN POINT X,Y
		// STORE SECOND NUMBER INTO dropInPt[0] THIRD # INTO dropInPt[1]
	     dropInPt[0] = inputFile.nextInt();
		 dropInPt[1] = inputFile.nextInt();
		// USING ROW, COL DEFINE A 2D ARRAY OF INT
		int [][] swamp = new int [rowCol][rowCol];
		// USE A NESTED LOOP. OUTER LOOP ROWS, INNER LOOP COLS
		for(int r = 0; r < swamp.length; r++)
			for(int c = 0; c < swamp.length; c++)
		// READ IN THE GRID OF VALUES FROM THE INPUT FILE
			swamp[r][c] = inputFile.nextInt();
		// CLOSE THE SCANNER
		inputFile.close();
		// RETURN THE 2D ARRAY WITH VALUES LOADED INTO IT
		return swamp;
		//return null;  // JUST TO MAKE IT COMPILE
	}

	static void dfs( int row, int col, String path ) // dfs = DEPTH FIRST SEARCH
	{
		// IMPLEMENT THE DFS ALGORITHM IN HERE
		
	path = path + "[" + Integer.toString(row) + "," + Integer.toString(col) + "]";
		
		if(row == 0 || col == 0 || row == swamp.length - 1 || col == swamp.length -1){
			System.out.println(path);
			return;
		}
		if(swamp[row - 1][col] == 1) //north case
		{
			swamp[row][col] = -1;
		    dfs(row -1,col, path);
			swamp[row][col] = 1;
		 
		}
		 if(swamp[row - 1][col + 1] == 1)  // northeast
		{
			 swamp[row][col] = -1;
		     dfs(row-1,col+1, path);
			 swamp[row][col] = 1;
		 
		}
		if(swamp[row][col+ 1] == 1)  // east
		{
			swamp[row][col] = -1;
		    dfs(row, col+1,path);
            swamp[row][col] = 1;
		 
		}		   
		if(swamp[row + 1][col + 1] == 1)  // southeast
		{
			swamp[row][col] = -1;
		    dfs(row + 1, col+1,path);
            swamp[row][col] = 1;
		 
		}	
		if(swamp[row + 1][col] == 1)  // south
		{
			swamp[row][col] = -1;
		    dfs(row + 1, col,path);
            swamp[row][col] = 1;
		}	
		if(swamp[row + 1][col - 1] == 1)  // southwest
	    {
			swamp[row][col] = -1;
		    dfs(row + 1, col - 1,path);
            swamp[row][col] = 1;
		 
		}	
		if(swamp[row][col - 1] == 1)  // west
		{
			swamp[row][col] = -1;
		    dfs(row, col - 1,path);
            swamp[row][col] = 1;
			
		}	
		if(swamp[row - 1][col - 1] == 1)  // northwest
		{
			swamp[row][col] = -1;
		    dfs(row - 1, col - 1,path);
            swamp[row][col] = 1;
		}	
		  
		
	}	
}