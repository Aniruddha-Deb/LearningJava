package com.sensei.UnitConverter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ParseModule module = new ParseModule();
		
		System.out.println( "Enter the unit and quantity to be converted: " );
		String str = new Scanner( System.in ).nextLine();
		ArrayList<Token> ans = module.process( str );
		
		System.out.println( "==============================" );
		System.out.println( ans.get(0).getValue() );
		for( int i=0; i<ans.get(0).getUnit().getSubUnits().size(); i++ ) {
			System.out.println( ans.get(0).getUnit().getSubUnits().get(i).getUnit() + 
								" " +
								ans.get(0).getUnit().getSubUnits().get(i).getDimension() );
		}
	}
}
