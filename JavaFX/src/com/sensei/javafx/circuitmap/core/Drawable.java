package com.sensei.javafx.circuitmap.core;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
	
	public void render( GraphicsContext g2d );
	
	public void erase( GraphicsContext g2d );
}
