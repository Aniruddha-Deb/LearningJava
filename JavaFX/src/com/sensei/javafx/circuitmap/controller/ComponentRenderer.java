package com.sensei.javafx.circuitmap.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ComponentRenderer {

	public void renderBattery( Canvas c, int x, int y ) {
		GraphicsContext g2d = c.getGraphicsContext2D();
		g2d.setStroke( Color.BLACK );
		g2d.setLineWidth( 1 );
		g2d.strokeRect( x, y-30, 45, 30 );
		g2d.strokeLine( x, y-15, x+20, y-15 );
		g2d.strokeLine( x+20, y, x+20, y-30 );
		g2d.strokeLine( x+25, y-10, x+25, y-20 );
		g2d.strokeLine( x+25, y-15, x+45, y-15 );
	}	
	
	public void clear( Canvas c ) {
		GraphicsContext g2d = c.getGraphicsContext2D();
		g2d.clearRect( 0, 0, c.getWidth(), c.getHeight() );
	}
}
