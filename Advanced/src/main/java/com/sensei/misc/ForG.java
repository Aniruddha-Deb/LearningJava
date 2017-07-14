package com.sensei.misc;

import java.util.Scanner;

public class ForG {

	public static void main(String[] args) {
		int base = 65;
		Scanner sc = new Scanner( System.in );
		
		System.out.print( "Enter a character: " );
		char c = sc.next().charAt( 0 );
		char trueChar = Character.toUpperCase( c );
		int difference = (int)trueChar-base+1;
		
		for( int i=difference; i>0; i-- ) {
			
			int num=0;
			
			for( int j=0; j<difference*2-1; j++ ) {
				if( num >= i ) {
					System.out.print( " " );
				}
				else {
					System.out.print( (char)(base+num) );
				}
				
				if( j>=difference-1 ) {
					num--;
				}
				else {
					num++;
				}
			}
			System.out.println(  );
		}
				
	}
}
