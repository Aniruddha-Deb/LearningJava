package com.sensei.javafx.circuitmap.core.components;

public class ComponentFactory {
	
	public enum ComponentType {
		CELL, DUMMY;
	}
	
	public static Component createComponent( ComponentType c ) {
		switch( c ) {
			case CELL:
				return new Cell();
				
			case DUMMY:
				return new Dummy();
		}
		return null;
	}

}
