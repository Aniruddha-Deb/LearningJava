package com.sensei.javafx.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application{

	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		VBox root = new VBox();
		Canvas c = new Canvas( 500, 500 );
		root.getChildren().add( c );
		GraphicsContext g = c.getGraphicsContext2D();
		
		Scene s = new Scene( root, 500, 500 );
		
		primaryStage.setTitle( "Hello FX!" );
		primaryStage.setScene( s );
		primaryStage.show();		
	}
	
	public void render(GraphicsContext g, int fs) {
		
		Text t = new Text( "C" );
		t.setFont( new Font( "Helvetica", fs ) );
		
		double rem = Math.rint( t.getLayoutBounds().getHeight() );
		double rin = Math.rint( t.getLayoutBounds().getWidth() );
				
		g.clearRect( 0, 0, 500, 500 );
		g.setFill( Color.BLACK );
		g.setFont( new Font( "Helvetica", fs ) );
		g.strokeLine( 250, 250, 250, 250 );
		g.fillText( "C", 250-(rin/2), 250+(rem/2.5) );
		g.setStroke( Color.LIGHTGRAY );
		g.setLineWidth( 2 );
		g.strokeArc( 250-rem, 250-rem, rem*2, rem*2, 0, 360, ArcType.CHORD );
		g.strokeArc( 250-(rem*2.5), 250-(rem*2.5), rem*5, rem*5, 0, 360, ArcType.CHORD );
	}
}
