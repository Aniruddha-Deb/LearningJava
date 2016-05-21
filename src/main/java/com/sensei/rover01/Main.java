package com.sensei.rover01;

public class Main {

	private Grid grid = null;
	private Rover rover = null;
	private UI ui = null;

	public void runProgram() {
		
		String cmd = null;
		do {
			
			grid = new Grid( 5, 8 );
			rover = new Rover( grid.getOrigin(), 100 );
			ui = new UI( grid, rover );
			
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
			if( rover.getEnergyLeft() <= 0 && rover.getCurrentCell().getDepth() > -1000 ) {
				System.out.println( "YOU LOSE!" );
				System.out.println( "Press p to play again" );
				keepPlaying = false;
			}
			else if( rover.getCurrentCell().getDepth() <= -1000 ) {
				System.out.println( "YOU WIN!" );
				System.out.println( "Press p to play again" );
				keepPlaying = false;
			}
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
		else if( cmd.equalsIgnoreCase( "drill" ) ) {
			executeDrillCmd( cmdParams );
			return true;
		}
		else {
			System.out.println( cmd + ": Unrecognized command" );
		}
		return true ;
	}

	private void executeDrillCmd( String[] cmdParams ) {
		int depth = 0;
		
		if( cmdParams.length == 2 ) {
			depth = Integer.parseInt( cmdParams[1] );
			rover.drill( depth );
		}
		else {
			System.out.println( "Invalid command" );
		}
		
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
