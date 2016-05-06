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

	public void execute( String choice ) {
		int previousX = 0;
		int previousY = 0;
		
		if( choice.matches( "[eEwWnNsS]" ) ) {
			
			if( choice.matches( "[eE]" ) ) {
				previousX = currentCell.getxCoord();
				currentCell.setxCoord( previousX + 1 );
				setCurrentCell( currentCell );
			}
			
			else if( choice.matches( "[wW]" ) ) {
				previousX = currentCell.getxCoord();
				currentCell.setxCoord( previousX - 1 );
				setCurrentCell( currentCell );
			}
			
			else if( choice.matches( "[nN]" ) ) {
				previousY = currentCell.getyCoord();
				currentCell.setxCoord( previousY - 1 );
				setCurrentCell( currentCell );
			}
			
			else if( choice.matches( "[sS]" ) ) {
				previousY = currentCell.getyCoord();
				currentCell.setxCoord( previousY + 1 );
				setCurrentCell( currentCell );
			}
		}
		else 
			System.out.println( choice + ": Direction undefined" );
	}
}
