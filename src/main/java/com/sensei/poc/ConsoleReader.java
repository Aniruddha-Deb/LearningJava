package com.sensei.poc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
		String line = null ;
		
		do {
			System.out.print( "Enter the next line: " ) ;
			line = reader.readLine() ;
			System.out.println( "Entered : " + line ) ;
		}
		while( !line.trim().equals( "exit" ) ) ;
	}
}


