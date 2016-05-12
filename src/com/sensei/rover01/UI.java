package com.sensei.rover01;

import java.util.Scanner;

public class UI {
	
	private String choice = null;
	private Scanner scanner = new Scanner( System.in );
	private Grid grid = null;
	private Rover rover = null;
	
	public UI( Grid g, Rover r ) {
		grid = g;
		rover = r;
	}
	
	public String getInput() {
		System.out.print( ":> " );
		choice = scanner.nextLine();
		return choice;
	}
	
	public void printStartMenu() {
		System.out.println( "           ROVER v1.0 beta" );
		System.out.println( "======================================");
		System.out.println( "What would you like to do?");
		System.out.println( "    P) Play game" );
		System.out.println( "    I) Display instructions" );
		System.out.println( "    E) Exit" );
		System.out.println( "======================================");
	}
	
	private void printIndividualCell( boolean occupied, int depth ) {
		
		if( depth < 0 && occupied ) {
			printNegativeCell( true, depth );
		}
		else if( depth < 0 ) {
			printNegativeCell( false, depth );
		}
		else if( depth >= 0 && occupied ) {
			printPositiveCell( true, depth );
		}
		else {
			printPositiveCell( false, depth );
		}
	}
	
	private void printNegativeCell( boolean occupied, int depth ) {
		if( occupied ) {
			printNegativeOccupiedCell( depth );
		}
		else {
			printNegativeUnoccupiedCell( depth );
		}
	}
	
	private void printPositiveCell( boolean occupied, int depth ) {
		if( occupied ) {
			printPositiveOccupiedCell( depth );
		}
		else {
			printPositiveUnoccupiedCell( depth );
		}
	}
	
	private void printNegativeOccupiedCell( int depth ) {
		String[] negativeBuffer = { "    ", "   ", "  ", " " };
		
		if( depth < 0 && depth > -10 )
			System.out.print( "\u2B24" + depth + negativeBuffer[0] );
		else if( depth <= -10 && depth > -100 )
			System.out.print( "\u2B24" + depth + negativeBuffer[1] );
		else if( depth <= -100 && depth > -1000 )
			System.out.print( "\u2B24" + depth + negativeBuffer[2] );
		else 
			System.out.print( "\u2B24" + depth + negativeBuffer[3] );
	}
	
	private void printNegativeUnoccupiedCell( int depth ) {
		String[] negativeBuffer = { "    ", "   ", "  ", " " };
		
		if( depth < 0 && depth > -10 )
			System.out.print( "\u25EF" + depth + negativeBuffer[0] );
		else if( depth <= -10 && depth > -100 )
			System.out.print( "\u25EF" + depth + negativeBuffer[1] );
		else if( depth <= -100 && depth > -1000 )
			System.out.print( "\u25EF" + depth + negativeBuffer[2] );
		else 
			System.out.print( "\u25EF" + depth + negativeBuffer[3] );
	}
	
	private void printPositiveOccupiedCell( int depth ) {
		String[] flagBuffer = { "     ", "    ", "   ", "  " };
		
		if( depth >= 0 && depth < 10 )
			System.out.print( "\u2B24" + depth + flagBuffer[0] );
		else if( depth >= 10 && depth < 100 )
			System.out.print( "\u2B24" + depth + flagBuffer[1] );
		else if( depth >= 100 && depth < 1000 )
			System.out.print( "\u2B24" + depth + flagBuffer[2] );
		else 
			System.out.print( "\u2B24" + depth + flagBuffer[3] );
	}
	
	private void printPositiveUnoccupiedCell( int depth ) {
		String[] flagBuffer = { "     ", "    ", "   ", "  " };
		
		if( depth >= 0 && depth < 10 )
			System.out.print( "\u25EF" + depth + flagBuffer[0] );
		else if( depth >= 10 && depth < 100 )
			System.out.print( "\u25EF" + depth + flagBuffer[1] );
		else if( depth >= 100 && depth < 1000 )
			System.out.print( "\u25EF" + depth + flagBuffer[2] );
		else 
			System.out.print( "\u25EF" + depth + flagBuffer[3] );
	}
	

	private void printCell( boolean isOccupied, boolean printValue, Cell cell ) {
		
		String buffer = "      ";
		
		if( isOccupied && printValue ) 
			printIndividualCell( true, cell.getDepth() );
		else if( printValue )
			printIndividualCell( false, cell.getDepth() );
		else 
			System.out.print( "\u25EF" + buffer );
	}

	public void printGrid() {
		
		Cell[][] cells = grid.getCells();
		int energyLeft = rover.getEnergyLeft();
		
		System.out.println( "Energy = " + energyLeft );
		for( int row=0; row < cells.length; row++ ) {
			
			Cell[] rowCells = cells[ row ];
			if( row != 0 ) {
				System.out.println( "" );
				System.out.println( "" );
			}
			
			for( int col=0; col < rowCells.length; col++ ) {
				
				Cell cell = rowCells[ col ];
				
				if( rover.isOnCell( cell ) ) {
					printCell( true, true, cell );
				}
				else if( rover.hasVisitedCell( cell ) ) {
					printCell( false, true, cell );
				}
				else{
					printCell( false, false, cell );
				}
			}
		}
		System.out.println( "" );
	}

	public void printInstructions() {
	}
}
