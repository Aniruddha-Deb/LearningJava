package com.sensei.rover01;

public class Main {

	public static void main(String[] args) {
		Grid grid = new Grid( 5, 8 );
		Rover rover = new Rover( grid.getOrigin() );
		UI ui = new UI( grid, rover );
		
		do {
			ui.printStartMenu();
			
			if( ui.getChoice().matches( "[Pp]" ) ) {
				
			}
			else if( ui.getChoice().matches( "[Ii]" ) ) {
				
			}
			else if( ui.getChoice().matches( "[Ee]" ) ) {
				
			}
			else {
				
			}
		} while( true );
	}

}
