package com.sensei.javafx.circuitmap;

import com.sensei.javafx.circuitmap.controller.UIController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircuitMap extends Application{

	public static void main( String[] args ) {
		launch( args );
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		UIController c = new UIController();
		FXMLLoader loader = new FXMLLoader( getClass().getResource( "view/MainUI.fxml" ) );
		loader.setController( c );
		AnchorPane root = loader.load();
		
		GraphicsContext g = c.canvas.getGraphicsContext2D();
		g.setFill( Color.WHITE );
		g.fillRect( 0, 0, c.canvas.getWidth(), c.canvas.getHeight() );
				
		Scene s = new Scene( root );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
