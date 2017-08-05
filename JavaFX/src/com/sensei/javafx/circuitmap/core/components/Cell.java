package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Cell extends Component {
	
	Cell() {
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
		
		g2d.strokeLine( x, y+20, x+10, y+20 );
		g2d.strokeLine( x+10, y, x+10, y+40 );
		g2d.strokeLine( x+20, y+10, x+20, y+30 );
		g2d.strokeLine( x+20, y+20, x+30, y+20 );
	}

}
