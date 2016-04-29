package com.sensei.rover;

import java.util.Random;
import java.util.Scanner;

public class Rover {
	
	static String choice = null;
	static Scanner scanner = new Scanner( System.in );
	static int[][] depths = new int[5][8];
	int maxX = 8, maxY = 5;
	static int xCoord = 0;
	static int yCoord = 0;

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
				depths[i][j] = rand.nextInt( ( 100 - 10 ) + 1 ) + 10;
			}
		}
	}
	
	public static void getRoverCoordinates() {
		
		while( true ) {
			System.out.print( "Next location X coordinate:> " );
			xCoord = scanner.nextInt();
			if( xCoord <= 8 && xCoord > 0 ) 
				break;
			else if( xCoord <= 0 ) 
				System.out.println( "Coordinate out of bounds. MinX is 1" );
			else 
				System.out.println( "Coordinate out of bounds. MaxX is 8" );
		}
		
		while( true ) {
			System.out.print( "Next location Y coordinate:> " );
			yCoord = scanner.nextInt();
			if( yCoord <= 5 && yCoord > 0 ) 
				break;
			else if( yCoord <=0 ) 
				System.out.println( "Coordinate out of bounds. MinY is 1" );
			else 
				System.out.println( "Coordinate out of bounds. MaxY is 5" );
		}
	}
	
	public static void drawBoard() {
		
		for( int i=0; i<5; i++ ) {
			
			System.out.println( "" );
			System.out.println( "" );
			
			for( int j=0; j<8; j++ ) {
				if( xCoord == j+1 && yCoord == i+1 ) {
					if( xCoord != 1 ) {
						System.out.print( "\u25EF" + depths[i][j] + "    " );
						j++;
					}
					System.out.print( "\u2B24" + depths[i][j] + "    " );
					j++;
					if( xCoord != 8 ) {
						System.out.print( "\u25EF" + depths[i][j] + "    " );
					}
				}
				else{
					System.out.print( "\u25EF" + "      " );
				}
			}
		}
		
		System.out.println( "" );
	}
	
	public static void playGame() {
		
		int moves = 0;
		xCoord = 1;
		yCoord = 1;
		
		generateDepths();
		drawBoard();
		
		do{
			getRoverCoordinates();
			drawBoard();
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
