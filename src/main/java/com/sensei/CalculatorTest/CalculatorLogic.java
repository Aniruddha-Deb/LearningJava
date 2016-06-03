package com.sensei.CalculatorTest;

import java.util.Scanner;

public class CalculatorLogic {

	public static void main(String[] args) {
		String calcString = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print( "Enter the calculatable string:" );
		calcString = scanner.nextLine();
		
		String[] calculation = calcString.split( "[+\\-*/]" );
		
		for( int i=0; i<calculation.length; i++ ) {
			System.out.print( calculation[i] + " " );
		}
		
		scanner.close();
	}
}
