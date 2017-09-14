package com.sensei.javafx.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application{

	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		VBox root = new VBox();
		Canvas c = new Canvas( 500, 500 );
		root.getChildren().add( c );
		GraphicsContext g = c.getGraphicsContext2D();
		
		Text t = new Text( "C" );
		t.setFont( new Font( "Helvetica", 128 ) );
		
		double rem = Math.rint( t.getLayoutBounds().getHeight() )-4;
		double rin = Math.rint( t.getLayoutBounds().getWidth() );
				
		System.out.println( rem + " " + rin );
		
		g.setFill( Color.BLACK );
		g.setFont( new Font( "Helvetica", 128 ) );
		g.strokeLine( 250, 250, 250, 250 );
		g.fillText( "C", 250-(rin/2), 250+(rem/2) );
		g.setStroke( Color.LIGHTGRAY );
		g.setLineDashes( 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 );
		g.strokeArc( 250-10, 250-10, 20, 20, 0, 360, ArcType.CHORD );
		g.strokeArc( 250-25, 250-25, 50, 50, 0, 360, ArcType.CHORD );
		
		Scene s = new Scene( root, 500, 500 );
		
		primaryStage.setTitle( "Hello FX!" );
		primaryStage.setScene( s );
		primaryStage.show();
	}
}
