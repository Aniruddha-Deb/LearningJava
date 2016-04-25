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
	
	public static void playGame() {
		
	}
	
	public static void displayInstructions() {
		
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
