package com.sensei.rover01;

public class EnergyBar {
	
	private int energy = 0;
	
	public EnergyBar( int energy ) {
		this.energy = energy;
	}
	
	public void reduceEnergy( int reduction ) {
		energy = energy - reduction;
	}
	
	public void increaseEnergy( int increase ) {
		energy = energy + increase;
	}
	
	public int getEnergy() {
		return energy;
	}

}
