package com.sensei.IO.objectIO;

import java.io.Serializable;

public class Character implements Serializable{
	
	private static final long serialVersionUID = 6867045495891354302L;
	private String name = null;
	private int power;
	
	public Character( String name, int power ) {
		this.name = name;
		this.setPower(power);
	}
	
	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
