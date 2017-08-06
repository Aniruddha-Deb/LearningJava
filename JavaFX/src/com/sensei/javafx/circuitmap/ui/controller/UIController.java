package com.sensei.javafx.circuitmap.ui.controller;

import com.sensei.javafx.circuitmap.core.Renderer;
import com.sensei.javafx.circuitmap.core.components.Component;
import com.sensei.javafx.circuitmap.core.components.ComponentFactory;
import com.sensei.javafx.circuitmap.core.components.ComponentFactory.ComponentType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class UIController {
	
	@FXML
	public Canvas canvas;
	
	@FXML
	public Canvas overlay;
	
	private Renderer renderer = null;
	private Component selectedComponent = null;
	private ComponentType selectedComponentType = ComponentType.DUMMY;
	
	@FXML
	public void initialize(){
		renderer = new Renderer( overlay, canvas );
		selectedComponent = ComponentFactory.createComponent( selectedComponentType );
	}
	
	@FXML
	public void onCanvasMouseClick( MouseEvent e ) {
		renderer.clearCurrentComponentPreview();
		renderer.drawCurrentComponentAt( new Point2D( e.getX(), e.getY() ) );
		selectedComponent = ComponentFactory.createComponent( selectedComponentType );
		selectedComponent.setLocation( new Point2D( e.getX(), e.getY() ) );
		renderer.setCurrentComponent( selectedComponent );		
	}
		
	@FXML
	public void onCanvasMouseEntered( MouseEvent e ) {
		Point2D currPoint = new Point2D( e.getX(), e.getY() );
		selectedComponent = ComponentFactory.createComponent( selectedComponentType );
		selectedComponent.setLocation( currPoint );
		renderer.setCurrentComponent( selectedComponent );
		renderer.previewCurrentComponentAt( currPoint );
	}
	
	@FXML
	public void onCanvasMouseMoved( MouseEvent e ) {
		renderer.previewCurrentComponentAt( new Point2D( e.getX(), e.getY() ) );
	}
	
	@FXML
	public void onCanvasMouseExited( MouseEvent e ) {
		renderer.clearCurrentComponentPreview();
	}
	
	@FXML
	public void onEscapeKeyPressed( KeyEvent e ) {
	}
	
	@FXML 
	public void onNewFileButtonClick( ActionEvent e ) {
	}
	
	@FXML 
	public void onOpenFileButtonClick( ActionEvent e ) {
	}

	@FXML 
	public void onSaveFileButtonClick( ActionEvent e ) {
	}

	@FXML 
	public void onUndoButtonClick( ActionEvent e ) {
		renderer.undo();
	}

	@FXML 
	public void onRedoButtonClick( ActionEvent e ) {
		renderer.redo();
	}

	@FXML 
	public void onCellButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.CELL;
	}

	@FXML 
	public void onResistorButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.RESISTOR;
	}

	@FXML 
	public void onCapacitorButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.CAPACITOR;
	}

	@FXML 
	public void onVoltmeterButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.VOLTMETER;
	}

	@FXML 
	public void onAmmeterButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.AMMETER;
	}

	@FXML 
	public void onKeyButtonClick( ActionEvent e ) {
		selectedComponentType = ComponentType.KEY;
	}

	@FXML 
	public void onWireButtonClick( ActionEvent e ) {
	}

	@FXML 
	public void onEraserButtonClick( ActionEvent e ) {
	}	
}
