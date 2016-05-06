package com.sensei.rover01;

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
				cells[row][col] = new Cell( row, col, row+col, this );
			}
		}
	}
	
	public Cell getOrigin() {
		return cells[0][0];
	}
	
	public Cell getCell( int xCoord, int yCoord ) {
		return cells[yCoord][xCoord];
	}
	
	public Cell[][] getCells() {
		return cells;
	}

	public Cell getRelativeCell(Cell currentCell, String dir, int steps) {
		int nextX = currentCell.getxCoord();
		int nextY = currentCell.getyCoord();
		
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

	public Cell[] getNeighborCells(Cell currentCell) {
		// TODO
		return null;
	}
}
