package com.sensei.javafx.circuitmap.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ComponentRenderer {
	
	private Canvas mainCanvas = null;
	private Canvas overlayCanvas = null;

	private GraphicsContext main = null;
	private GraphicsContext overlay = null;
	
	public ComponentRenderer( Canvas main, Canvas overlay ) {
		this.mainCanvas = main;
		this.overlayCanvas = overlay;
		
		this.main = main.getGraphicsContext2D();
		this.overlay = overlay.getGraphicsContext2D();
	}

	public void renderBatteryPreview( int x, int y ) {
		renderBattery( overlay, x, y );
	}
	
	private void renderBattery( GraphicsContext g2d, int x, int y ) {
		g2d.setStroke( Color.BLACK );
		g2d.setLineWidth( 1 );
		g2d.strokeLine( x, y-20, x+20, y-20 );
		g2d.strokeLine( x+20, y, x+20, y-40 );
		g2d.strokeLine( x+30, y-10, x+30, y-30 );
		g2d.strokeLine( x+30, y-20, x+50, y-20 );
	}
	
	public void drawBattery( int x, int y ) {
		renderBattery( main, x, y );
	}
	
	public void clearOverlay() {
		overlay.clearRect( 0, 0, overlayCanvas.getWidth(), 
								overlayCanvas.getHeight() );
	}
}
