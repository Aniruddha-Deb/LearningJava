package com.sensei.rover01;

public class Rover {

	private Cell currentCell = null;
	
	public Rover( Cell origin ) {
		currentCell = origin;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	public boolean isOnCell( Cell cell ) {
		return cell == currentCell;
	}

	public boolean isNearCell( Cell cell ) {
		return currentCell.isNearCell( cell );
	}

	public boolean hasVisitedCell( Cell cell ) {
		return cell.hasBeenVisited();
	}
}
