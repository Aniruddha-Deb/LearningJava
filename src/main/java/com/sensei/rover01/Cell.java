package com.sensei.rover01;

public class Cell {
	
	private int depth = 0;
	private int xCoord = 0;
	private int yCoord = 0;
	private boolean visited = false;
	private Grid grid = null ;
	
	public Cell( int y, int x, int depth, Grid grid ) {
		xCoord = x;
		yCoord = y;
		this.depth = depth;
		this.grid = grid ;
	}
	
	public Grid getGrid() {
		return this.grid ;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth( int depth ) {
		this.depth = depth;
	}

	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public void setVisited() {
		visited = true;
	}

	public boolean hasBeenVisited() {
		return visited;
	}

	public double computeDistanceFrom(Cell centerCell) {
		return Math.sqrt( Math.pow( centerCell.xCoord - xCoord, 2) + 
				          Math.pow( centerCell.yCoord - yCoord, 2) ) ;
	}

}
