package com.sensei.misc;

import java.util.HashSet;
import java.util.Scanner;

public class DoubleLetters {

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		while( true ) {
			System.out.print("> " );
			String input = sc.nextLine();
			HashSet<Character> chars = new HashSet<Character>();
			
			if( input.equals( "quit" ) ) {
				break;
			}
			
			for( char ch : input.toCharArray() ) {
				if( ch == ' ' ) {
					continue;
				}
				else if( !( chars.add(ch) ) ) {
					System.out.println( "bad" );
					break;
				}
			}
		}
		sc.close();
	}

}
