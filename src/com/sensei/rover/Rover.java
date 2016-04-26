package com.sensei.rover;

import java.util.Scanner;

public class Rover {
	
	static String choice = null;
	static Scanner scanner = new Scanner( System.in );

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
	
	public static void drawBoard() {
		
		System.out.println( "" );
		System.out.println( "" );
		
		for( int i=0; i<5; i++ ) {
			for( int j=0; j<8; j++ ) {
				System.out.print( "\u2022" + "        " );
			}
			System.out.println( "" );
			System.out.println( "" );
			System.out.println( "" );
		}
	}
	
	public static void playGame() {
		drawBoard();
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
