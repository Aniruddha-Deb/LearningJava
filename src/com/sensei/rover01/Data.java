package com.sensei.rover01;

import java.util.Random;

public class Data {
	
	int[][] depths = null;
	int numRows = 0;
	int numCols = 0;
	
	int hillX = 0, valleyX = 0;
	int hillY = 0, valleyY = 0;
	
	public Data( int numRows, int numCols ) {
		depths = new int[numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	public void generateBumpMap() {
		Random rand = new Random();
		generateFirstBump( rand );
		generateSecondBump( rand );
	}
	
	public int getDepth( int xCoord, int yCoord ) {
		return depths[yCoord][xCoord];
	}
	
	private int randInt( int min, int max, Random rand ) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	private void generateFirstBump( Random rand ) {
		
		// randomly generating the location of the bumps 
		hillX = rand.nextInt(numCols);
		hillY = rand.nextInt(numRows);
		valleyX = rand.nextInt(numCols);
		valleyY = rand.nextInt(numRows);

		// checking if the bumps are in proximity. if yes, then regenerating the bumps
		if( valleyX == hillX || valleyX == hillX+1 || valleyX == hillX-1 ) 
			valleyX = rand.nextInt(numCols);
		if( valleyY == hillY || valleyY == hillY+1 || valleyY == hillY-1 )
			valleyY = rand.nextInt(numRows);
		
		depths[valleyY][valleyX] = randInt( 10, 30, rand ) * -1;
		depths[hillY][hillX] = randInt( 30, 60, rand );
	}
	
	private void generateSecondBump( Random rand ) {

		int depth = depths[hillY][hillX];
		int buffer = randInt( depth-30, depth-10, rand );
		generateSecondHillBump( buffer );
		
		depth = depths[valleyY][valleyX] * -1;
		buffer = randInt( depth-20, depth-10, rand ) * -1; 
		generateSecondValleyBump( buffer );
		
	}
	
	private void generateSecondHillBump( int buffer ) {
		
		if( hillX != 0 )
			depths[hillY][hillX-1] = buffer;
		
		if( hillX != 7)
			depths[hillY][hillX+1] = buffer;
		
		for( int i=0; i<2; ) {
			if( i==0 ) {
				if( hillY != 0 && hillX != 0 )
					depths[hillY-1][hillX-1] = buffer;
				if( hillY != 7 && hillX != 0 )
					depths[hillY+1][hillX-1] = buffer;
			}
			// TODO
			else {
				if( hillY != 7 && hillX != 7-i )
					depths[hillY-1][hillX+i] = buffer;
				depths[hillY+1][hillX+i] = buffer;
				i++;
			}
		}
	}
	
	private void generateSecondValleyBump( int buffer ) {
		depths[valleyY][valleyX-1] = buffer;
		depths[valleyY][valleyX+1] = buffer;
		
		for( int i=0; i<2; ) {
			if( i==0 ) {
				depths[valleyY-1][valleyX-1] = buffer;
				depths[valleyY+1][valleyX-1] = buffer;
			}
			else {
				depths[valleyY-1][valleyX+i] = buffer;
				depths[valleyY+1][valleyX+i] = buffer;
				i++;
			}
		}
	}
}
