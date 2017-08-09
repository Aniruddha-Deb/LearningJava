package com.sensei.javafx.circuitmap.ui.controller;

import com.sensei.javafx.circuitmap.core.Renderer;
import com.sensei.javafx.circuitmap.core.components.Component;
import com.sensei.javafx.circuitmap.core.components.ComponentFactory;
import com.sensei.javafx.circuitmap.core.components.ComponentFactory.ComponentType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UIController {
	
	@FXML
	public Canvas canvas;
	
	@FXML
	public Canvas overlay;
	
	private Renderer renderer = null;
	private ObjectProperty<Component> currentComponent = null;
	private ComponentType currentComponentType = null;
	private Point2D gridSnapLocation = null;
	
	private Stage stage = null;	
	
	public UIController( Stage stage ) {
		this.stage = stage;
		currentComponentType = ComponentType.DUMMY;
		currentComponent = new SimpleObjectProperty<>( 
				ComponentFactory.createComponent( currentComponentType ) );
	}
	
	@FXML
	public void initialize(){
		bindCanvasProperties();
		renderer = new Renderer( overlay, canvas );		
		renderer.currentComponent().bind( currentComponent );
	}
	
	private void bindCanvasProperties() {
		overlay.widthProperty().bind( stage.widthProperty() );
		overlay.heightProperty().bind( stage.heightProperty() );
		canvas.widthProperty().bind( stage.widthProperty() );
		canvas.widthProperty().bind( stage.heightProperty() );
	}
	
	@FXML
	public void onCanvasMouseClick( MouseEvent e ) {
		renderer.drawCurrentComponent();
		currentComponent.set( ComponentFactory.createComponent( currentComponentType ) );
		currentComponent.get().setLocation( gridSnapLocation );
	}
		
	@FXML
	public void onCanvasMouseEntered( MouseEvent e ) {
		calculateGridSnapLocation( e );
		stage.getScene().setCursor( Cursor.CROSSHAIR );
		currentComponent.set( ComponentFactory.createComponent( currentComponentType ) );
		currentComponent.get().setLocation( gridSnapLocation );
		renderer.previewCurrentComponent();
	}
	
	@FXML
	public void onCanvasMouseMoved( MouseEvent e ) {		
		calculateGridSnapLocation( e );
		renderer.clearComponentPreview();
		currentComponent.get().setLocation( gridSnapLocation );
		renderer.previewCurrentComponent();
	}
	
	private void calculateGridSnapLocation( MouseEvent e ) {
		int xBoundary = 5;
		int yBoundary = 5;
		
		double nearestX = xBoundary * ( Math.ceil( Math.abs( e.getX()/xBoundary ) ) );
		double nearestY = yBoundary * ( Math.ceil( Math.abs( e.getY()/yBoundary ) ) );

		gridSnapLocation = new Point2D( nearestX, nearestY );
	}
	
	@FXML
	public void onCanvasMouseExited( MouseEvent e ) {
		stage.getScene().setCursor( Cursor.DEFAULT );
		renderer.clearComponentPreview();
		gridSnapLocation = null;
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
		currentComponentType = ComponentType.CELL;
	}

	@FXML 
	public void onResistorButtonClick( ActionEvent e ) {
		currentComponentType = ComponentType.RESISTOR;
	}

	@FXML 
	public void onCapacitorButtonClick( ActionEvent e ) {
		currentComponentType = ComponentType.CAPACITOR;
	}

	@FXML 
	public void onVoltmeterButtonClick( ActionEvent e ) {
		currentComponentType = ComponentType.VOLTMETER;
	}

	@FXML 
	public void onAmmeterButtonClick( ActionEvent e ) {
		currentComponentType = ComponentType.AMMETER;
	}

	@FXML 
	public void onKeyButtonClick( ActionEvent e ) {
		currentComponentType = ComponentType.KEY;
	}

	@FXML 
	public void onWireButtonClick( ActionEvent e ) {
	}

	@FXML 
	public void onEraserButtonClick( ActionEvent e ) {
	}	
}
