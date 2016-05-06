package com.sensei.rover01;

public class Main {

	public static void main(String[] args) {
		Grid grid = new Grid( 5, 8 );
		Rover rover = new Rover( grid.getOrigin() );
		UI ui = new UI( grid, rover );
		String choice = null;
		
		do {
			ui.printStartMenu();
			choice = ui.getChoice();
			
			if( choice.matches( "[Pp]" ) ) {
				int moves = 0;
				ui.printGrid();
				
				do {
					choice = ui.getChoice();
					rover.execute( choice );
					ui.printGrid();
					moves++;
				} while( moves < 10 );
			}
			
			else if( choice.matches( "[Ii]" ) ) {
				ui.printInstructions();
			}
			
			else if( choice.matches( "[Ee]" ) ) {
				System.exit( -1 );
			}
			
			else {
				System.out.println( "Undefined instruction. Please retry." );
			}
		} while( true );
	}

}
