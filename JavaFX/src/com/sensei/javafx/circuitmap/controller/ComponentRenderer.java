package com.sensei.javafx.circuitmap.controller;

import com.sensei.javafx.circuitmap.controller.UIController.Tool;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ComponentRenderer {
	
	private Canvas mainCanvas = null;
	private Canvas overlayCanvas = null;

	private GraphicsContext main = null;
	private GraphicsContext overlay = null;
	
	public ComponentRenderer( UIController c ) {
		this.mainCanvas = c.canvas;
		this.overlayCanvas = c.overlay;
		
		this.main = mainCanvas.getGraphicsContext2D();
		main.scale( 2, 2 );
		this.overlay = overlayCanvas.getGraphicsContext2D();
		overlay.scale( 2, 2 );
	}

	public void renderComponentPreview( Tool t, int x, int y ) {
		render( overlay, t, x, y );
	}
	
	public void drawComponent( Tool t, int x, int y ) {
		render( main, t, x, y );
	}
	
	private void render( GraphicsContext g2d, Tool t, int x, int y ) {
		g2d.setStroke( Color.BLACK );
		g2d.setLineWidth( 1 );
		
		if( t != null ) {
			switch( t ) {
				case CELL: 
					renderCell( g2d, x, y );
				break;
				
				case RESISTOR:
					renderResistor( g2d, x, y );
				break;	
				
				case AMMETER:
					renderAmmeter( g2d, x, y );
				break;
				
				case CAPACITOR:
					renderCapacitor( g2d, x, y );
				break;
				
				case KEY:
					renderKey( g2d, x, y );
				break;
				
				case VOLTMETER:
					renderVoltmeter( g2d, x, y );
				break;

				case WIRE:
					renderWire( g2d, x, y );
				break;
			}
		}
	}
	
	private void renderCell( GraphicsContext g2d, int x, int y ) {
		g2d.strokeLine( x, y-20, x+10, y-20 );
		g2d.strokeLine( x+10, y, x+10, y-40 );
		g2d.strokeLine( x+20, y-10, x+20, y-30 );
		g2d.strokeLine( x+20, y-20, x+30, y-20 );
	}
	
	private void renderResistor( GraphicsContext g2d, int x, int y ) {
				
		g2d.strokeLine( x, y, x+2.5, y );		
		g2d.strokeLine( x+2.5, y, x+5, y+5 );
		
		for( int i=5; i<30; i+=10 ) {
			g2d.strokeLine( x+i, y+5, x+i+5, y-5 );
			g2d.strokeLine( x+i+5, y-5, x+i+10, y+5 );			
		}
		
		g2d.strokeLine( x+35, y+5, x+37.5, y );		
		g2d.strokeLine( x+37.5, y, x+40, y );
	}
	
	private void renderCapacitor( GraphicsContext g2d, int x, int y ) {
		g2d.strokeLine( x, y, x+17.5, y );
		g2d.strokeLine( x+17.5, y-15, x+17.5, y+15 );
		g2d.strokeLine( x+22.5, y-15, x+22.5, y+15 );
		g2d.strokeLine( x+22.5, y, x+40, y );
	}
	
	private void renderVoltmeter( GraphicsContext g2d, int x, int y ) {
		g2d.strokeLine( x, y, x+5, y );
		g2d.strokeArc( x+5, y-15, 30, 30, 90, 360, ArcType.CHORD );
		g2d.setTextAlign( TextAlignment.CENTER );
		g2d.setFont( new Font( "Helvetica", 20 ) );
		g2d.fillText( "V", x+20, y+7.5 );
		g2d.strokeLine( x+35, y, x+40, y );
	}
	
	private void renderAmmeter( GraphicsContext g2d, int x, int y ) {
		g2d.strokeLine( x, y, x+5, y );
		g2d.strokeArc( x+5, y-15, 30, 30, 90, 360, ArcType.CHORD );
		g2d.setTextAlign( TextAlignment.CENTER );
		g2d.setFont( new Font( "Helvetica", 20 ) );
		g2d.fillText( "A", x+20, y+7.5 );
		g2d.strokeLine( x+35, y, x+40, y );		
	}
	
	private void renderKey( GraphicsContext g2d, int x, int y ) {
		g2d.strokeLine( x, y, x+10, y );
		g2d.strokeArc( x+10, y-10, 20, 20, 90, 360, ArcType.CHORD );
		g2d.clearRect( x+17, y-11, 6, 22 );
		g2d.fillArc( x+18, y-2, 4, 4, 90, 360, ArcType.CHORD );
		g2d.strokeLine( x+30, y, x+40, y );		
	}
	
	private int wireStartX = -1;
	private int wireStartY = -1;
	
	public void setWireStartCoordinates( int x, int y ) {
		this.wireStartX = x;
		this.wireStartY = y;
	}
	
	private void renderWire( GraphicsContext g2d, int x, int y ) {
		if( wireStartX != -1 && wireStartY != -1 ) {
			g2d.strokeLine( wireStartX, wireStartY, x, y );
		}
	}
	
	public void resetWireStartCoordinates() {
		this.wireStartX = -1;
		this.wireStartY = -1;
	}
	
	public void clearOverlay() {
		overlay.clearRect( 0, 0, overlayCanvas.getWidth(), 
								overlayCanvas.getHeight() );
	}
	
	public void clearComponentPreview( Tool t, int x, int y ) {
		if( t != Tool.WIRE ) {
			overlay.clearRect( x-50, y-50, 100, 100 );		
		}
		else if( wireStartX != -1 && wireStartY != -1 ) {
			clearOverlay();
		}
	}
}
