package com.sensei.javafx.circuitmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CircuitMap extends Application{

	public static void main( String[] args ) {
		launch( args );
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		AnchorPane root = FXMLLoader.load( getClass().getResource( "view/MainUI.fxml" ) );
				
		Scene s = new Scene( root );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
