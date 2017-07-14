package com.sensei.JavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Helloworld extends Application implements EventHandler<ActionEvent>{
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle( "Hello world!" );
		primaryStage.show();

		StackPane layout = new StackPane();
		button = new Button();
		button.setText( "Hello World!" );
		button.setOnAction( this );
		layout.getChildren().add( button );
		
		Scene scene = new Scene( layout, 300, 250 );
		primaryStage.setScene( scene );
	}

	public void handle(ActionEvent event) {
		if( event.getSource() == button ) {
			System.out.println( "Hello there!" );
		}
	}
}
