package com.sensei.rover01;

import java.util.Random;

public class Data {
	
	int[][] depths = null;
	int numRows = 0;
	int numCols = 0;
	
	public Data( int numRows, int numCols ) {
		depths = new int[numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	public void generateBumpMap() {
		Random rand = new Random();
		
		int x1 = 0, x2 = 0;
		int y1 = 0, y2 = 0;
		
		x1 = rand.nextInt(numCols);
		y1 = rand.nextInt(numRows);
		
		x2 = rand.nextInt(numCols);
		y2 = rand.nextInt(numRows);
		
		if( x1 == x2 ) 
			x2 = rand.nextInt(numCols);
		if( y1 == y2 )
			y2 = rand.nextInt(numRows);
		
		depths[y2][x2] = rand.nextInt(-30) - 10;
		depths[y1][x1] = rand.nextInt(30) + 30;
		
	}
	
}
