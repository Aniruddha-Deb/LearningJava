package com.sensei.UnitConverter;

public class Token {

	private double value;
	private Unit unit;

	public Token( String value, Unit unit ) {
		this.value = Double.parseDouble( value );
		this.unit = unit;
	}
	
	public double getValue() {
		return value;
	}

	public Unit getUnit() {
		return unit;
	}
}
