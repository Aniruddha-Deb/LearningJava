package com.sensei.bookMananger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {

	private BufferedReader reader = null ;
	
	public ConsoleReader() {
		reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
	}
	
	private String readLine() {
		String line = null ;
		try {
			line = reader.readLine().trim() ;
		}
		catch( Exception e ) {
			e.printStackTrace() ;
		}
		return line ;
	}
	
	public String getString( String prompt ) {
		System.out.print( prompt + ": " ) ;
		return readLine() ;
	}
	
	public int getInt( String prompt ) {
		int val = 0 ;
		boolean valueRead = false ;
		
		do {
			System.out.print( prompt + ": " ) ;
			String text = readLine() ;
			try {
				val = Integer.parseInt( text ) ;
				valueRead = true ;
			} 
			catch (NumberFormatException e) {
				System.out.println( "Please enter an integer value." ) ;
			}
		}
		while( !valueRead ) ;
		
		return val ;
	}

	public boolean getUserConfirmation( String prompt ) {
		String input = null;
		boolean bool = true;
		do {
			System.out.print( prompt + "(y/n): ");
			input = readLine();
			if( input.matches( "[Yy]" ) ) {
				bool = true;
				break;
			}
			else if( input.matches( "[Nn]" ) ) {
				bool = false;
				break;
			}
		}while( !input.matches( "[YyNn]" ) );
		
		return bool;
	}
}
