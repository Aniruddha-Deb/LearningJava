package com.sensei.JavaFX.LoginPrompt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainStage extends Application {
	
	Button login;
	Label userName, password ;
	Text welcome, alert;
	TextField userNameInput, passwordInput;

	public static void main(String[] args) {
		launch( args );
	}

	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment( Pos.CENTER );
		gridPane.setHgap( 10 );
		gridPane.setVgap( 10 );
		gridPane.setPadding( new Insets( 25, 25, 25, 25 ) );

		welcome = new Text( "Welcome" );
		welcome.setFont( Font.font( "Helvetica", 30 ) );
		gridPane.add( welcome, 0, 0, 2, 1 );
		
		userName = new Label( "User name: " );
		gridPane.add( userName, 0, 1 );
		
		userNameInput = new TextField();
		gridPane.add( userNameInput, 1, 1);
		
		password = new Label( "Password: " );
		gridPane.add( password , 0, 2);

		passwordInput = new TextField();
		gridPane.add( passwordInput, 1, 2 );
		
		login = new Button( "Log in" );
		login.setOnAction( e -> {
			alert.setFill( Color.FIREBRICK );
			alert.setText( "Sign in button pressed" );
			loginPressed();
		} );
		HBox hbbtn = new HBox( 10 );
		hbbtn.setAlignment( Pos.BOTTOM_RIGHT );
		hbbtn.getChildren().add( login );
		gridPane.add( hbbtn, 1, 3);
		
		alert = new Text();
		gridPane.add( alert, 1, 5);
		
		Scene scene = new Scene( gridPane, 350, 300 );
		primaryStage.setScene( scene );
		
		primaryStage.setTitle( "JavaFX Login" );
		primaryStage.show();
	}
	
	private void loginPressed() {
		if( userNameInput.getText().equals( "Deba" ) && 
			passwordInput.getText().equals( "1234" ) ) {
			new SecondStage();
		}
	}

}
