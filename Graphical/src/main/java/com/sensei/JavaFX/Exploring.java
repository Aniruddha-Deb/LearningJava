package com.sensei.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exploring extends Application {

	public static void main(String[] args) {
		launch( args );
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu( "File" );
		BorderPane mainLayout = new BorderPane();
		
		menuBar.getMenus().add( fileMenu );
		mainLayout.getChildren().add( menuBar );

		Scene scene = new Scene( mainLayout, 400, 400 );
		primaryStage.setTitle( "Exploring JavaFX" );
		primaryStage.setScene( scene );
		primaryStage.show();
		
	}

}
