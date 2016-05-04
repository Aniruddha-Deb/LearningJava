package com.sensei.rover01;

public class Grid {
	
	private Cell[][] cells = null;
	
	public Grid( int rows, int columns ) {
		cells = new Cell[ rows ][ columns ];
		
		for( int row=0; row < rows; row++ ) {
			for( int col=0; col < columns; col++ ) {
				cells[row][col] = new Cell( row, col, row+col );
			}
		}
	}
	
	public Cell getOrigin() {
		return cells[0][0];
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	
}
