package com.sensei.rover01;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	
	private Cell[][] cells = null;
	private int numRows = 0 ;
	private int numCols = 0 ;
	
	public Grid( int rows, int columns ) {
		
		numRows = rows ;
		numCols = columns ;
		cells = new Cell[ rows ][ columns ];
		
		for( int row=0; row < rows; row++ ) {
			for( int col=0; col < columns; col++ ) {
				cells[row][col] = new Cell( row, col, 0, this );
			}
		}
		Topographer t = new Topographer( this );
		t.generateBumps();
	}
	
	public Cell getOrigin() {
		return cells[0][0];
	}
	
	public Cell getCell( int xCoord, int yCoord ) {
		if( xCoord < numCols && xCoord >= 0 && yCoord < numRows && yCoord >= 0 ) {
			return cells[yCoord][xCoord];
		}
		return null;
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public Cell[][] getCells() {
		return cells;
	}

	public Cell getRelativeCell(Cell currentCell, String dir, int steps) {
		int nextX = currentCell.getXCoord();
		int nextY = currentCell.getYCoord();
		
		if( dir.equalsIgnoreCase( "e" ) ) {
			nextX += steps;
		}
		else if( dir.equalsIgnoreCase( "w" ) ) {
			nextX -= steps;
		}
		else if( dir.equalsIgnoreCase( "s" ) ) {
			nextY += steps;
		}
		else if( dir.equalsIgnoreCase( "n" ) ) {
			nextY -= steps;
		}
		else {
			System.out.println( "Invalid direction specified" );
			return null;
		}
		
		if( nextX >= numCols || nextY >= numRows || nextX < 0 || nextY < 0 ) {
			System.out.println( "Target cell out of bounds" );
			return null;
		}
		return getCell( nextX, nextY );
	}

	public List<Cell> getNeighborCells(Cell centerCell, int radius, double tolerance ) {
		List<Cell> cells = new ArrayList<Cell>() ;
		
		int tlx = centerCell.getXCoord() - radius ;
		int tly = centerCell.getYCoord() - radius ;
		int brx = centerCell.getXCoord() + radius ;
		int bry = centerCell.getYCoord() + radius ;
		
		for( int x = tlx; x <= brx; x++ ) {
			for( int y = tly; y <= bry; y++ ) {
				if( withinGridBound( x, y ) ) {
					Cell currentCell = getCell( x, y ) ;
					double distance = currentCell.computeDistanceFrom( centerCell ) ;
					if( distance <= radius + tolerance ) {
						cells.add( getCell( x, y ) ) ;
					}
				}
			}
		}
		return cells ;
	}
	
	private boolean withinGridBound( int x, int y ) {
		return ( x >= 0 && x < numCols ) && ( y >= 0 && y < numRows ) ;
	}
}
