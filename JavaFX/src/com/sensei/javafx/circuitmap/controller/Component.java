package com.sensei.javafx.circuitmap.controller;

import com.sensei.javafx.circuitmap.controller.UIController.Tool;

public class Component {
	
	private int startX = 0;
	private int endX = 0;
	private int startY = 0;
	private int endY = 0;
	private Tool componentType = null;

	public Component( int startX, int endX, int startY, int endY, Tool type ) {
		this.startX = startX;
		this.endX = endX;
		this.startY = startY;
		this.endY = endY;
		this.componentType = type;
	}

	public int getStartX(){
		return startX;
	}

	public int getEndX(){
		return endX;
	}

	public int getStartY(){
		return startY;
	}

	public int getEndY(){
		return endY;
	}

	public Tool getComponentType(){
		return componentType;
	}
}
