package com.sensei.javafx.circuitmap.core;

import java.util.ArrayDeque;

import com.sensei.javafx.circuitmap.core.components.Component;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Renderer {
	
	private ArrayDeque<Component> drawnComponents = null;
	private ArrayDeque<Component> undoneComponents = null;
	private Component currentComponent = null;
	
	private boolean canDraw = true;
	
	private Canvas previewCanvas = null;
	private Canvas mainCanvas = null;

	public Renderer( Canvas preview, Canvas main ) {
		this.previewCanvas = preview;
		this.mainCanvas = main;
		
		drawnComponents = new ArrayDeque<>();
		undoneComponents = new ArrayDeque<>();
	}
	
	public void setCurrentComponent( Component c ) {
		this.currentComponent = c;
	}
	
	public void previewCurrentComponentAt( Point2D location ) {

		canDraw = true;
		drawnComponents.forEach( (c) -> {
			double x = location.getX();
			double y = location.getY();
			
			double cStartX = c.getStart().getX()-currentComponent.getWidth()+0.5;
			double cStartY = c.getStart().getY()-currentComponent.getHeight()+0.5;
			double cEndX = c.getEnd().getX()-0.5;
			double cEndY = c.getEnd().getY()-0.5;
			
			if( ( x > cStartX && x < cEndX ) && ( y > cStartY && y < cEndY ) ) {
				canDraw = false;
			}
		});
		
		if( !canDraw ) {
			previewCanvas.getGraphicsContext2D().setStroke( Color.RED );
			previewCanvas.getGraphicsContext2D().setFill( Color.RED );
		}
		else {
			previewCanvas.getGraphicsContext2D().setStroke( Color.BLACK );
			previewCanvas.getGraphicsContext2D().setFill( Color.BLACK );			
		}
		currentComponent.erase( previewCanvas.getGraphicsContext2D() );
		currentComponent.setLocation( location );
		currentComponent.render( previewCanvas.getGraphicsContext2D() );		
	}
	
	public void clearCurrentComponentPreview() {
		currentComponent.erase( previewCanvas.getGraphicsContext2D() );
	}
	
	public void drawCurrentComponentAt( Point2D location ) {

		if( canDraw ) {
			currentComponent.setLocation( location );
			currentComponent.render( mainCanvas.getGraphicsContext2D() );
			drawnComponents.push( currentComponent );
			currentComponent = null;
		}
	}
	
	public void undo() {
		Component previousComponent = drawnComponents.pop();
		previousComponent.erase( mainCanvas.getGraphicsContext2D() );
		undoneComponents.push( previousComponent );
	}
	
	public void redo() {
		Component nextComponent = undoneComponents.pop();
		nextComponent.render( mainCanvas.getGraphicsContext2D() );
		drawnComponents.push( nextComponent );		
	}
}
