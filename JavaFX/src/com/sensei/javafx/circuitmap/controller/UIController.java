package com.sensei.javafx.circuitmap.controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UIController {
	
	@FXML
	public Canvas canvas;
	@FXML
	public Canvas overlay;
	
	private int currX = 0;
	private int currY = 0;
	private int xStep = 10;
	private int yStep = 10;
	
	private Stage mainStage = null;
	private ComponentRenderer renderer = null;
	
	public UIController( Stage mainStage ) {
		this.mainStage = mainStage;
		renderer = new ComponentRenderer();
	}
	
	@FXML
	public void onCanvasMouseClick( MouseEvent e ) {
		renderer.renderBattery( canvas, currX, currY  );
	}
		
	@FXML
	public void onCanvasMouseEntered( MouseEvent e ) {
		mainStage.getScene().setCursor( Cursor.NONE );
		renderer.renderBattery( overlay, currX, currY );
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
		
		if( currY != prevY ) {
			renderer.clear( overlay );
			renderer.renderBattery( overlay, currX, currY );
		}
		else if( currX != prevX ) {
			renderer.clear( overlay );
			renderer.renderBattery( overlay, currX, currY );			
		}
	}
	
	@FXML
	public void onCanvasMouseExited( MouseEvent e ) {
		mainStage.getScene().setCursor( Cursor.DEFAULT );
	}
}
