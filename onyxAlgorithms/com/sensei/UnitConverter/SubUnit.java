package com.sensei.UnitConverter;

public class SubUnit {
	
	private String unit      = null;
	private int    dimension = 0;
	
	public SubUnit( String unit, int dimension ) {
		this.unit = new String( unit );
		this.dimension = dimension;
	}

	public String getUnit() {
		return unit;
	}

	public int getDimension() {
		return dimension;
	}	
}
