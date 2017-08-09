package com.sensei.javafx.circuitmap.core;

import java.util.ArrayDeque;

import com.sensei.javafx.circuitmap.core.components.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Renderer {
	
	private ArrayDeque<Component> drawnComponents = null;
	private ArrayDeque<Component> undoneComponents = null;
	private ObjectProperty<Component> currentComponent = null;
	private boolean canDraw = true;
	
	private Canvas previewCanvas = null;
	private Canvas mainCanvas = null;

	public Renderer( Canvas preview, Canvas main ) {
		this.previewCanvas = preview;
		this.mainCanvas = main;
		
		currentComponent = new SimpleObjectProperty<>();
		
		drawnComponents = new ArrayDeque<>();
		undoneComponents = new ArrayDeque<>();
	}
	
	public ObjectProperty<Component> currentComponent() {
		return currentComponent;
	}
	
	public void previewCurrentComponent() {

		canDraw = true;
		drawnComponents.forEach( (c) -> {			
			double x = currentComponent.get().getStart().getX();
			double y = currentComponent.get().getStart().getY();
			
			double cStartX = c.getStart().getX()-currentComponent.get().getWidth()+0.5;
			double cStartY = c.getStart().getY()-currentComponent.get().getHeight()+0.5;
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
		currentComponent.get().erase( previewCanvas.getGraphicsContext2D() );
		currentComponent.get().render( previewCanvas.getGraphicsContext2D() );		
	}
	
	public void clearComponentPreview() {
		currentComponent.get().erase( previewCanvas.getGraphicsContext2D() );
	}
	
	public void drawCurrentComponent(){

		if( canDraw ) {
			currentComponent.get().render( mainCanvas.getGraphicsContext2D() );
			drawnComponents.push( currentComponent.get() );
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
