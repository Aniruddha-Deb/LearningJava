package com.sensei.rover01;

public class Rover {

	private Cell currentCell = null;
	
	public Rover( Cell origin ) {
		setCurrentCell( origin );
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell nextCell) {
		if( nextCell != null ) {
			this.currentCell = nextCell;
			currentCell.setVisited();
			
			Cell[] nCells = currentCell.getGrid().getNeighborCells( currentCell ) ;
			for( Cell neighbor : nCells ) {
				if( neighbor != null ) {
					neighbor.setVisited() ;
				}
			}
		}
	}

	public boolean isOnCell( Cell cell ) {
		return cell == currentCell;
	}

	public boolean hasVisitedCell( Cell cell ) {
		return cell.hasBeenVisited();
	}

	public void move(String dir, int steps) {
		
		Grid grid = currentCell.getGrid() ;
		Cell nextCell = grid.getRelativeCell( currentCell, dir, steps ) ;
		setCurrentCell( nextCell );
	}
}
