package com.sensei.javafx.circuitmap.controller;

import java.util.Stack;

import com.sensei.javafx.circuitmap.controller.component.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UIController {
	
	enum Tool {
		CELL, RESISTOR, CAPACITOR, VOLTMETER, AMMETER, KEY, WIRE, ERASER; 		
	}
	
	@FXML
	public Canvas canvas;
	@FXML
	public Canvas overlay;
	
	private int currX = 0;
	private int currY = 0;
	private int xStep = 10;
	private int yStep = 10;
	
	private Tool currentTool = null;
	
	private Stage mainStage = null;
	private ComponentRenderer renderer = null;
	
	private Stack<Component> componentStack = null;
	
	public void pushComponent( Component c ) {
		System.out.println( "Added " + c.toString() );
		componentStack.push( c );
	}
	
	public Component popComponent() {
		return componentStack.pop();
	}
	
	public Stack<Component> getComponentStack(){
		return componentStack;
	}
	
	public UIController( Stage mainStage ) {
		this.mainStage = mainStage;
		this.componentStack = new Stack<>();
	}

	@FXML
	public void initialize(){
		renderer = new ComponentRenderer( this );
	}
	
	@FXML
	public void onCanvasMouseClick( MouseEvent e ) {
		if( currentTool == Tool.WIRE ) {
			renderer.drawComponent( currentTool, currX/2, currY/2 );
			renderer.setWireStartCoordinates( currX/2, currY/2 );
		}
		else if( currentTool == Tool.ERASER ) {
			// TODO implement editStack.
		}
		else {
			renderer.drawComponent( currentTool, currX/2, currY/2 );
		}
	}
		
	@FXML
	public void onCanvasMouseEntered( MouseEvent e ) {
		if( currentTool != Tool.WIRE ) {
			mainStage.getScene().setCursor( Cursor.NONE );
		}
		else if( currentTool == null ) {
			mainStage.getScene().setCursor( Cursor.DEFAULT );
		}
		else {
			mainStage.getScene().setCursor( Cursor.CROSSHAIR );			
		}
		renderer.renderComponentPreview( currentTool, currX/2, currY/2 );
	}
	
	@FXML
	public void onCanvasMouseMoved( MouseEvent e ) {
		int prevX = currX;
		int prevY = currY;
		
		if( e.getX() > currX+(xStep/2) ) {
			currX = currX + xStep;
		}
		else if( e.getX() < currX-(xStep/2) ) {
			currX = currX - xStep;
		}
		
		if( e.getY() > currY+(yStep/2) ) {
			currY = currY + yStep;
		}
		else if( e.getY() < currY-(yStep/2) ) {
			currY = currY - yStep;
		}		
		
		if( currY != prevY || currX != prevX ) {
			renderer.clearComponentPreview( currentTool, prevX/2, prevY/2 );
			renderer.renderComponentPreview( currentTool, currX/2, currY/2 );			
		}
	}
	
	@FXML
	public void onCanvasMouseExited( MouseEvent e ) {
		mainStage.getScene().setCursor( Cursor.DEFAULT );
		renderer.resetWireStartCoordinates();
		renderer.clearOverlay();
	}
	
	@FXML
	public void onEscapeKeyPressed( KeyEvent e ) {
		if( currentTool == Tool.WIRE ) {
			renderer.setWireStartCoordinates( -1, -1 );
			renderer.clearOverlay();
		}
		else {
			renderer.clearComponentPreview( currentTool, currX/2, currY/2 );
			currentTool = null;
			mainStage.getScene().setCursor( Cursor.DEFAULT );			
		}
	}
	
	@FXML 
	public void onNewFileButtonClick( ActionEvent e ) {
		// TODO implement file IO and make new file
	}
	
	@FXML 
	public void onOpenFileButtonClick( ActionEvent e ) {
		// TODO implement file IO and open a file		
	}

	@FXML 
	public void onSaveFileButtonClick( ActionEvent e ) {
		// TODO implement file IO and save current file				
	}

	@FXML 
	public void onUndoButtonClick( ActionEvent e ) {
		// TODO keep a stack of edits and pop()
	}

	@FXML 
	public void onRedoButtonClick( ActionEvent e ) {
		// TODO keep a stack of edits and push() from the undone stack
	}

	@FXML 
	public void onCellButtonClick( ActionEvent e ) {
		currentTool = Tool.CELL;
	}

	@FXML 
	public void onResistorButtonClick( ActionEvent e ) {
		currentTool = Tool.RESISTOR;		
	}

	@FXML 
	public void onCapacitorButtonClick( ActionEvent e ) {
		currentTool = Tool.CAPACITOR;		
	}

	@FXML 
	public void onVoltmeterButtonClick( ActionEvent e ) {
		currentTool = Tool.VOLTMETER;		
	}

	@FXML 
	public void onAmmeterButtonClick( ActionEvent e ) {
		currentTool = Tool.AMMETER;
	}

	@FXML 
	public void onKeyButtonClick( ActionEvent e ) {
		currentTool = Tool.KEY;		
	}

	@FXML 
	public void onWireButtonClick( ActionEvent e ) {
		currentTool = Tool.WIRE;		
	}

	@FXML 
	public void onEraserButtonClick( ActionEvent e ) {
		currentTool = Tool.ERASER;
	}	
}
