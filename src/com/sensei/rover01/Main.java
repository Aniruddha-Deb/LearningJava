package com.sensei.rover01;

public class Main {

	public static void main(String[] args) {
		Grid grid = new Grid( 5, 8 );
		Rover rover = new Rover( grid.getOrigin() );
		UI ui = new UI( grid, rover );
		
		ui.printGrid();
		
		
	}

}
