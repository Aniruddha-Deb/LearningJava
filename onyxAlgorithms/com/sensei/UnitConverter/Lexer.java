package com.sensei.UnitConverter;

import java.util.ArrayList;

public class Lexer {

	public ArrayList<Token> lex( String str ) {

		String[] buffer = str.split( " " );
		ArrayList<Token> tokens = new ArrayList<Token>(); 
		
		String value = new String();
		Unit unit = new Unit();
		
		for( String string : buffer ) {
			if( string.matches("\\d+") ) {
				value = string;
			}
			else {
				unit.addSubUnit( getUnit( string ), getDimension( string ) );
			}
		}
		
		tokens.add( new Token( value, unit ) );
		
		return tokens;
	}
	
	private int getDimension( String string ) {
		int dimension = 0;
		StringBuilder dimString = new StringBuilder();
		
		for( int i=0; i<string.length(); i++ ) {
			if( !Character.isLetter( string.charAt(i) ) ) {
				dimString.append( string.charAt(i) );
			}
		}
		
		try{
			dimension = Integer.parseInt( dimString.toString() );
		}
		catch( Exception e ) {
			dimension = 1;
		}
		
		return dimension;
	}

	private String getUnit( String string ) {
		StringBuilder dimString = new StringBuilder();
		
		for( int i=0; i<string.length(); i++ ) {
			System.out.println( string.charAt(i) );
			if( Character.isLetter( string.charAt(i) ) ) {
				dimString.append( string.charAt(i) );
			}
		}
		
		return dimString.toString();
	}

}
