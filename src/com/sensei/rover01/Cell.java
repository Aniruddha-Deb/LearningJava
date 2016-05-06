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

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public boolean isNearCell( Cell cell ) {
		if( yCoord == cell.yCoord ) {
			if( xCoord == cell.xCoord-1 || xCoord == cell.xCoord+1 ) { 
				return true;
			}
		}
		else if( xCoord == cell.xCoord ) {
			if( yCoord == cell.yCoord-1 || yCoord == cell.yCoord+1 ) {
				return true;
			}
		}
		return false;
	}
	
	public void setVisited() {
		visited = true;
	}

	public boolean hasBeenVisited() {
		return visited;
	}

}
