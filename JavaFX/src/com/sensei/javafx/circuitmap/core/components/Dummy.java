package com.sensei.javafx.circuitmap.core.components;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Dummy extends Component {

	public Dummy() {
		super( null );
	}

	@Override
	public void render( GraphicsContext g2d ) {
		// do nothing
	}

	@Override
	public void setLocation( Point2D start ){
		super.setStart( start );
		super.setEnd( start );
	}
}
