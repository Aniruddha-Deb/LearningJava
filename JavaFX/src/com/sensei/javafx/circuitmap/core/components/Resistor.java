package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Resistor extends Component {
	
	Resistor() {
		super( "Cell" );
	}
	
	@Override
	public void setLocation( Point2D start ) {
		super.setStart( start );
		super.setEnd( new Point2D( start.getX()+40, start.getY()+40 ) );
	}
	
	@Override
	public void render( GraphicsContext g2d ){
		double x = super.getStart().getX();
		double y = super.getStart().getY();
		
		g2d.strokeLine( x, y+5, x+2.5, y+5 );		
		g2d.strokeLine( x+2.5, y+5, x+5, y+10 );
		
		for( int i=5; i<30; i+=10 ) {
			g2d.strokeLine( x+i, y+10, x+i+5, y );
			g2d.strokeLine( x+i+5, y, x+i+10, y+10 );			
		}		
		g2d.strokeLine( x+35, y+10, x+37.5, y+5 );		
		g2d.strokeLine( x+37.5, y+5, x+40, y+5 );
	}

}
