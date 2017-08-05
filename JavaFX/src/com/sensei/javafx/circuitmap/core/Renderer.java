package com.sensei.javafx.circuitmap.core;

import java.util.ArrayDeque;

import com.sensei.javafx.circuitmap.core.components.Component;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

public class Renderer {
	
	private ArrayDeque<Component> drawnComponents = null;
	private ArrayDeque<Component> undoneComponents = null;
	private Component currentComponent = null;
	
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
		currentComponent.erase( previewCanvas.getGraphicsContext2D() );
		currentComponent.setLocation( location );
		currentComponent.render( previewCanvas.getGraphicsContext2D() );		
	}
	
	public void clearCurrentComponentPreview() {
		currentComponent.erase( previewCanvas.getGraphicsContext2D() );
	}
	
	public void drawCurrentComponentAt( Point2D location ) {
		currentComponent.setLocation( location );
		currentComponent.render( mainCanvas.getGraphicsContext2D() );
		drawnComponents.push( currentComponent );
		currentComponent = null;
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
