package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Voltmeter extends Component {
	
	Voltmeter() {
		super( "Cell" );
	}
	
	@Override
	public void setLocation( Point2D start ) {
		super.setStart( start );
		super.setEnd( new Point2D( start.getX()+40, start.getY()+30 ) );
	}
	
	@Override
	public void render( GraphicsContext g2d ){
		double x = super.getStart().getX();
		double y = super.getStart().getY();
		
		g2d.strokeLine( x, y+15, x+5, y+15 );
		g2d.strokeArc( x+5, y, 30, 30, 90, 360, ArcType.CHORD );
		g2d.setTextAlign( TextAlignment.CENTER );
		g2d.setFont( new Font( "Helvetica", 20 ) );
		g2d.fillText( "V", x+20, y+22.5 );
		g2d.strokeLine( x+35, y+15, x+40, y+15 );
	}

}
