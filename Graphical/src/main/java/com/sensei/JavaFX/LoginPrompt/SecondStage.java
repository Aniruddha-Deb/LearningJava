package com.sensei.JavaFX.LoginPrompt;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondStage extends Stage{

	public SecondStage() {
		initialize();
		super.show();
	}
	
	private void initialize() {
		VBox layout = new VBox( 10 );
		
		Label label = new Label( "You have succesfully logged in!" );
		
		Button button = new Button( "Log out" );
		button.setOnAction( e -> super.close() );
		layout.getChildren().addAll( label, button );
		layout.setAlignment( Pos.CENTER );
		
		Scene scene = new Scene( layout, 200, 200 );
		super.setScene( scene );
	}
}
