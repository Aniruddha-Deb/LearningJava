package com.sensei.rover;

import java.util.Random;
import java.util.Scanner;

public class Rover {
	
	static String choice = null;
	static Scanner scanner = new Scanner( System.in );
	static int[][] depths = new int[5][8];
	int maxX = 8, maxY = 5;
	static int roverX = 0;
	static int roverY = 0;

	public static void printStartMenu() {
		System.out.println( "            ROVER INDEV" );
		System.out.println( "======================================");
		System.out.println( "What would you like to do?");
		System.out.println( "    P) Play game" );
		System.out.println( "    I) Display instructions" );
		System.out.println( "    E) Exit" );
		System.out.println( "======================================");
		System.out.print  ( "Waiting on choice: ");
		choice = scanner.next();
	}
	
	public static void generateDepths() {
		Random rand = new Random();
		
		for( int i=0; i<5; i++ ) {
			for( int j=0; j<8; j++ ) {
				depths[i][j] = rand.nextInt( ( 99 - 10 ) + 1 ) + 10;
			}
		}
	}
	
	public static void getRoverCoordinates() {
		
		while( true ) {
			System.out.print( "Next location direction:> " );
			choice = scanner.next();
			if( choice.matches( "[eEwWnNsS]" ) ) {
				if( choice.matches( "[eE]" ) ) {
					if( roverX != 7 )
						roverX++;
					else
						System.out.println( "Maximum X coordinate Reached" );
				}
				else if( choice.matches( "[wW]" ) ) {
					if( roverX != 0 )
						roverX--;
					else
						System.out.println( "Minimum X coordinate Reached" );
				}
				else if( choice.matches( "[nN]" ) ) {
					if( roverY != 0 )
						roverY--;
					else
						System.out.println( "Minimum Y coordinate Reached" );
				}
				else if( choice.matches( "[sS]" ) ) {
					if( roverY != 4 )
						roverY++;
					else
						System.out.println( "Maximum Y coordinate Reached" );
				}
				break;
			}
			else 
				System.out.println( choice + ": Direction undefined" );
		}
	}
	
	public static void drawAndManageBoard() {
		
		for( int row=0; row<5; row++ ) {
			
			System.out.println( "" );
			System.out.println( "" );
			
			for( int col=0; col<8; ) {
				
				if( col == roverX-1 && roverY == row ) {
					if( roverX != 0 ) {
						System.out.print( "\u25EF" + depths[row][col] + "    " );
						col++;
					}
				}
				
				if( roverX == col && roverY == row ) {
					System.out.print( "\u2B24" + depths[row][col] + "    " );
					col++;
					if( roverX != 7 ) {
						System.out.print( "\u25EF" + depths[row][col] + "    " );
						col++;
					}
				}
				
				if( roverX == col && roverY == row+1 ) {
					System.out.print( "\u25EF" + depths[row][col] + "    " );
					col++;
				}
				
				if( roverX == col && roverY == row-1 ) {
					System.out.print( "\u25EF" + depths[row][col] + "    " );
					col++;
				}
				
				if( col < 8 ) {
					System.out.print( "\u25EF" + "      " );
					col++;
				}
			}
		}
		
		System.out.println( "" );
	}
	
	public static void playGame() {
		
		int moves = 0;
		
		generateDepths();
		drawAndManageBoard();
		
		do{
			getRoverCoordinates();
			drawAndManageBoard();
			moves++;
		}while( moves < 90 );
	}
	
	public static void displayInstructions() {
		System.out.println( "You serve as the captain of a Rover operating in Antarctica." );
		System.out.println( "Your orders are to tap into the deepest trench to discover fossils." );
		System.out.println( "" );
		System.out.println( "The board contains 40 trenches with the maximum X coordinate being 7 and the " );
		System.out.println( "maximum Y coordinate being 4. You start at 0,0. Type the coordinate to travel " );
		System.out.println( "to in the prompt. Once there, you can see the depths of the neighbouring " );
		System.out.println( "trenches. Once you are sure that the trench underneath is the deepest, hit Enter" );
		System.out.println( "to dig. If it is the deepest, you are successful. If not, better luck next time." );
	}
	
	public static void exit() {
		scanner.close();
		System.exit( -1 );
	}
	
	public static void main(String[] args) {
		
		do{
			printStartMenu();
			if( choice.matches( "[Pp]" ) ) 
				playGame();
			
			else if( choice.matches( "[Ii]" ) )
				displayInstructions();
			
			else if( choice.matches( "[Ee]" ) )
				exit();
		}while( true );
	}
}
