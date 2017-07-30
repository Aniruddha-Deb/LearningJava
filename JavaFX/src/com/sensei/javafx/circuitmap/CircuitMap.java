package com.sensei.javafx.circuitmap;

import com.sensei.javafx.circuitmap.controller.UIController;

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
		UIController c = new UIController( primaryStage );
		FXMLLoader loader = new FXMLLoader( getClass().getResource( "view/MainUI.fxml" ) );
		loader.setController( c );
		AnchorPane root = loader.load();
		
		Scene s = new Scene( root );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
