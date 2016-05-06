package com.sensei.rover01;

public class Main {

	private Grid grid = new Grid( 5, 8 );
	private Rover rover = new Rover( grid.getOrigin() );
	private UI ui = new UI( grid, rover );

	public void runProgram() {
		
		String cmd = null;
		do {
			ui.printStartMenu();
			cmd = ui.getInput();
			
			if( cmd.equalsIgnoreCase( "p" ) ) {
				playGame();
			}
			else if( cmd.equalsIgnoreCase( "i" ) ) {
				ui.printInstructions();
			}
			else if( cmd.equalsIgnoreCase( "e" ) ) {
				System.exit( -1 );
			}
			else {
				System.out.println( cmd + ": unrecognized choice" );
			}
			
		} while( true ) ;
	}
	
	private void playGame() {
		
		boolean keepPlaying = true ;
		ui.printGrid();
		
		do {
			String cmd = ui.getInput();
			
			String[] cmdParams = cmd.split( "\\s+" ) ; 
			keepPlaying = executeCommand( cmdParams );
			
			ui.printGrid();
		} while( keepPlaying ) ;
	}
	
	private boolean executeCommand( String[] cmdParams ) {

		String cmd = cmdParams[0];
		
		if( cmd.equalsIgnoreCase( "move" ) ) {
			executeMoveCmd( cmdParams ) ;
			return true ;
		}
		else if( cmd.equalsIgnoreCase( "quit" ) ) {
			return false ;
		}
		return false ;
	}

	private void executeMoveCmd( String[] cmdParams ) {
		
		String dir = null ;
		int    steps = 1 ;
		
		if( cmdParams.length > 1 ) {
			dir = cmdParams[1] ;
			if( cmdParams.length > 2 ) {
				steps = Integer.parseInt( cmdParams[2] ) ;
			}
			
			rover.move( dir, steps ) ;
		}
		else {
			System.out.println( "Invalid command" ) ;
		}
	}
	
	public static void main(String[] args) {
		new Main().runProgram() ;
	}
}
