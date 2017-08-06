package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Capacitor extends Component {
	
	Capacitor() {
		super( "Capacitor" );
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
		
		g2d.strokeLine( x, y+15, x+17.5, y+15 );
		g2d.strokeLine( x+17.5, y, x+17.5, y+30 );
		g2d.strokeLine( x+22.5, y, x+22.5, y+30 );
		g2d.strokeLine( x+22.5, y+15, x+40, y+15 );	
	}

}
