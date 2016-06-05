package com.sensei.algorithm;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int input=0;
		Scanner scanner = new Scanner( System.in ) ;
		
		System.out.print( "Enter the number whose factorial is to be found: " );
		input = scanner.nextInt();
		
		System.out.println( "The factorial of " + input + " is " + fact( input ) + "." );
		scanner.close();
	}
	
	private static int getFactorial( int n ) {
		int factorial = 1;
		for( int i=1; i<=n; i++ ) {
			factorial = factorial * i;
		}
		return factorial;
	}
	
	private static int fact( int n ) {
		if( n == 1 ) {
			return 1 ;
		}
		return n * fact( n -1 ) ;
	}
}
