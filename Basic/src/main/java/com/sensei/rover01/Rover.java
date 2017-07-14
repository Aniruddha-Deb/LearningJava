package com.sensei.rover01;

import java.util.List;

public class Rover {

	private Cell currentCell = null;
	private EnergyBar energyBar = null; 
	
	public Rover( Cell origin, int energy ) {
		setCurrentCell( origin );
		energyBar = new EnergyBar( energy );
	}
	
	public int getEnergyLeft() {
		return energyBar.getEnergy();
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell nextCell) {
		if( nextCell != null ) {
			this.currentCell = nextCell;
			currentCell.setVisited();
			
			List<Cell> nCells = currentCell.getGrid().getNeighborCells( currentCell, 1, 0 ) ;
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
		int energyRequired = (int) (2*steps);
		if( getEnergyLeft() >= energyRequired ) {
			
			Grid grid = currentCell.getGrid() ;
			Cell nextCell = grid.getRelativeCell( currentCell, dir, steps ) ;
			setCurrentCell( nextCell );
			energyBar.reduceEnergy( energyRequired );
		}
		else {
			System.out.println( "Cannot move, insufficient energy" );
		}
	}

	public void drill( int depth ) {
		int energyRequired = (int) (0.1*depth);
		
		if( getEnergyLeft() >= energyRequired ) {
			
			currentCell.setDepth( currentCell.getDepth() - depth );
			energyBar.reduceEnergy( energyRequired );
		}
		else {
			System.out.println( "Cannot drill to this depth, insufficient energy" );
		}
	}
}
