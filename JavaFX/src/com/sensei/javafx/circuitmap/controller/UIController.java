package com.sensei.javafx.circuitmap.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class UIController {
	
	@FXML
	public Canvas canvas;
	
	@FXML
	public void onCanvasMouseClick( MouseEvent e ) {
		GraphicsContext c = canvas.getGraphicsContext2D();
		c.setStroke( Color.BLACK );
		c.setLineWidth( 5 );
		c.strokeLine( e.getX(), e.getY(), e.getX(), e.getY() );
	}
}
