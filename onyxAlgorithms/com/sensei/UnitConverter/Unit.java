package com.sensei.UnitConverter;

import java.util.ArrayList;

public class Unit {

	private ArrayList<SubUnit> subUnits = null;
	
	public Unit() {
		subUnits = new ArrayList<SubUnit>();
	}
	
	public void addSubUnit( String unit, int dimension ) {
		subUnits.add( new SubUnit( unit, dimension ) );
	}

	public ArrayList<SubUnit> getSubUnits() {
		return subUnits;
	}
}
