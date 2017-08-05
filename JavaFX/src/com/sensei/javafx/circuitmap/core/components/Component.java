package com.sensei.javafx.circuitmap.core.components;

import com.sensei.javafx.circuitmap.core.Drawable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class Component implements Drawable{

	private String  name  = null;
	private Point2D start = null;
	private Point2D end   = null;
	
	protected Component( String name ) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Point2D getStart(){
		return start;
	}
	
	public Point2D getEnd(){
		return end;
	}
	
	public abstract void setLocation( Point2D start );
	
	protected void setEnd( Point2D end ) {
		this.end = end;
	}
	
	protected void setStart( Point2D start ) {
		this.start = start;
	}
		
	@Override
	public abstract void render( GraphicsContext g2d );

	@Override
	public void erase( GraphicsContext g2d ) {
		double w = end.getX()-start.getX();
		double h = end.getY()-start.getY();
		// +2 as buffer
		g2d.clearRect( start.getX()-2, start.getY()-2, w+4, h+4 );
	}
	
	@Override
	public String toString(){
		return name + "( " + start.getX() + ", " + start.getY() + " )";
	}
}
