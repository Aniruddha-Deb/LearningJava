package com.sensei.rover01;

public class Cell {
	
	private int depth = 0;
	private int xCoord = 0;
	private int yCoord = 0;
	
	public Cell( int x, int y, int depth ) {
		xCoord = x;
		yCoord = y;
		depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}

	public boolean hasRover() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isNearRover() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasBeenVisited() {
		// TODO Auto-generated method stub
		return false;
	}

}
