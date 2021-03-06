package com.sensei.rover01;

import java.util.List;
import java.util.Random;

public class Topographer {
	
	private Grid grid = null;
	private Random rand = new Random();
	
	private int minBumpRadius = 10 ;
	private int maxBumpRadius = 20 ;
	private int maxBumpDepth  = -50 ;
	private int maxBumpHeight = 50 ;
	private int numBumps = 50 ;
	
	public Topographer( Grid grid ) {
		this.grid = grid;
	}
	
	public void generateBumps() {
		for( int i=0; i<numBumps; i++ ) {
			createAndSuperimposeBump();
		}
	}
	
	private void createAndSuperimposeBump() {
		int centreX = 0;
		int centreY = 0;
		int radius = 0;
		int height = 0;
		
		centreX = randInt( 0, grid.getNumCols(), false );
		centreY = randInt( 0, grid.getNumRows(), false );
		radius = randInt( minBumpRadius, maxBumpRadius, true );
		
		if( rand.nextBoolean() ) {
			height = randInt( maxBumpDepth, maxBumpDepth/3, true );
		}
		else { 
			height = randInt( maxBumpHeight/3, maxBumpHeight, true );
		}
		
		List<Cell> bumpCells = grid.getNeighborCells(
				                   grid.getCell( centreX, centreY ),
				                   radius, 0.5 ) ;	
		
		for( Cell cell : bumpCells ) {
			computeCellHeight( cell, centreX, centreY, radius, height ) ;
		}
	}
	
	private void computeCellHeight( Cell cell, int cx, int cy, int r, int h ) {
		int h1 =  (int) ( (h/r)*(r-cell.computeDistanceFrom( grid.getCell( cx, cy ) ) ) );
		cell.setDepth( cell.getDepth() + h1 );
	}

	private int randInt( int min, int max, boolean inclusion ) {
		int randomNum = 0;
		
		if( inclusion )
			randomNum = rand.nextInt((max - min) + 1) + min;
		else 
			randomNum = rand.nextInt( max - min ) + min;
		return randomNum;
	}
	
}
