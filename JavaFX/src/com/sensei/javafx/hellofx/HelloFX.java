package com.sensei.javafx.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application{

	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		VBox root = new VBox();
		Text helloFX = new Text();
		helloFX.setText( "Hello FX!" );
		root.getChildren().add( helloFX );
		
		Scene s = new Scene( root, 300, 50 );
		
		primaryStage.setTitle( "Hello FX!" );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
