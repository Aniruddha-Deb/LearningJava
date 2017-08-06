package com.sensei.javafx.circuitmap.core.components;

public class ComponentFactory {
	
	public enum ComponentType {
		CELL, DUMMY, VOLTMETER, AMMETER, RESISTOR, CAPACITOR, KEY;
	}
	
	public static Component createComponent( ComponentType c ) {
		switch( c ) {
			case CELL:      return new Cell();				
			case DUMMY:     return new Dummy();				
			case AMMETER:   return new Ammeter();
			case CAPACITOR: return new Capacitor();
			case KEY:       return new Key();
			case RESISTOR:  return new Resistor();
			case VOLTMETER: return new Voltmeter();
		}
		return null;
	}

}
