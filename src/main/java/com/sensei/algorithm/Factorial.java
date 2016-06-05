package com.sensei.algorithm;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int input=0, i=0;
		int factorial = 1;
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Enter the number whose factorial is to be found: " );
		input = scanner.nextInt();
		scanner.close();
		
		for( i=1; i<=input; i++ ) {
			factorial = factorial * i;
		}
		
		System.out.println( "The factorial of " + input + " is " + factorial + "." );
	}
}
