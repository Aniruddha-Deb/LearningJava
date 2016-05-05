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
	
	public String getChoice() {
		System.out.print( ":> " );
		choice = scanner.next();
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
		getChoice();
	}

	private void printCell( boolean isOccupied, boolean printValue, Cell cell ) {
		
		String flagBuffer = "    ";
		String buffer = "     ";
		
		if( isOccupied && printValue ) 
			System.out.print( "\u2B24" + cell.getDepth() + flagBuffer );
		else if( printValue )
			System.out.print( "\u25EF" + cell.getDepth() + flagBuffer );
		else 
			System.out.print( "\u25EF" + buffer );
	}

	public void printGrid() {
		
		Cell[][] cells = grid.getCells();
		
		for( int row=0; row < cells.length; row++ ) {
			
			Cell[] rowCells = cells[ row ];
			
			System.out.println( "" );
			System.out.println( "" );
			
			for( int col=0; col < rowCells.length; col++ ) {
				
				Cell cell = rowCells[ col ];
				
				if( rover.isOnCell( cell ) ) {
					printCell( true, true, cell );
				}
				else if( rover.isNearCell( cell ) || rover.hasVisitedCell( cell ) ) {
					printCell( false, true, cell );
				}
				else{
					printCell( false, false, cell );
				}
			}
		}
		System.out.println( "" );
	}


}
