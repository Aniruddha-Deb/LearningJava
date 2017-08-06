package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Key extends Component {
	
	Key() {
		super( "Key" );
	}
	
	@Override
	public void setLocation( Point2D start ) {
		super.setStart( start );
		super.setEnd( new Point2D( start.getX()+40, start.getY()+20 ) );
	}
	
	@Override
	public void render( GraphicsContext g2d ){
		double x = super.getStart().getX();
		double y = super.getStart().getY();
		
		g2d.strokeLine( x, y+10, x+10, y+10 );
		g2d.strokeArc( x+10, y, 20, 20, 90, 360, ArcType.CHORD );
		g2d.clearRect( x+17, y-1, 6, 22 );
		g2d.fillArc( x+18, y+8, 4, 4, 90, 360, ArcType.CHORD );
		g2d.strokeLine( x+30, y+10, x+40, y+10 );	
	}

}
