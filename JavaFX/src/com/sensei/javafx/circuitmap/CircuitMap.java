package com.sensei.javafx.circuitmap;

import com.sensei.javafx.circuitmap.ui.controller.UIController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CircuitMap extends Application{
	
	private static final String VIEW_PATH = "ui/view/MainUI.fxml"; 

	public static void main( String[] args ) {
		launch( args );
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		UIController c = new UIController( primaryStage );
		FXMLLoader loader = new FXMLLoader( CircuitMap.class.getResource( VIEW_PATH ) );
		loader.setController( c );
		AnchorPane root = loader.load();
		
		Scene s = new Scene( root );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
