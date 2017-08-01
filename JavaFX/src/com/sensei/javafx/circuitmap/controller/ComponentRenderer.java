package com.sensei.javafx.circuitmap.controller;

import com.sensei.javafx.circuitmap.controller.UIController.Tool;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ComponentRenderer {
	
	private Canvas mainCanvas = null;
	private Canvas overlayCanvas = null;

	private GraphicsContext main = null;
	private GraphicsContext overlay = null;
	
	public ComponentRenderer( UIController c ) {
		this.mainCanvas = c.canvas;
		this.overlayCanvas = c.overlay;
		
		this.main = mainCanvas.getGraphicsContext2D();
		this.overlay = overlayCanvas.getGraphicsContext2D();
	}

	public void renderComponentPreview( Tool t, int x, int y ) {
		render( overlay, t, x, y );
	}
	
	private void render( GraphicsContext g2d, Tool t, int x, int y ) {
		if( t != null ) {
			g2d.setStroke( Color.BLACK );
			g2d.setLineWidth( 1 );
			g2d.strokeText( t.toString(), x, y );
		}
	}
	
	public void drawComponent( Tool t, int x, int y ) {
		render( main, t, x, y );
	}
	
	public void clearOverlay() {
		overlay.clearRect( 0, 0, overlayCanvas.getWidth(), 
								overlayCanvas.getHeight() );
	}
	
	public void clearRect( int startX, int startY ) {
		overlay.clearRect( startX-40, startY-40, 160, 80 );		
	}
}
