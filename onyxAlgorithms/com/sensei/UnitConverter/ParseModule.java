package com.sensei.UnitConverter;

import java.util.ArrayList;

public class ParseModule {
	
	private Lexer     lexer  = null;
	private Parser    parser = null;
	
	public ParseModule() {
		lexer = new Lexer();
		parser = new Parser();
	}
	
	public ArrayList<Token> process( String str ) {
		ArrayList<Token> tokens = lexer.lex( str );
		//tokens = parser.parse( tokens );
		
		return tokens;
	}

}
