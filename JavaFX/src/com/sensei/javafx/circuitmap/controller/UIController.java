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
	private int xStep = 20;
	private int yStep = 20;
	
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
		
		if( e.getX()-5 > currX+xStep ) {
			currX = currX + xStep;
		}
		else if( e.getX()+5 < currX - xStep ) {
			currX = currX - xStep;
		}
		
		if( e.getY()-5 > currY+yStep ) {
			currY = currY + yStep;
		}
		else if( e.getY()+5 < currX - xStep ) {
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
