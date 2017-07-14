package com.sensei.graphics2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Graphics2D_01 extends JPanel{
	
	private int x, y;
	
	public void setXY( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paint( Graphics g ) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor( Color.ORANGE );
		g2d.fillOval( x, y, 100, 100 );
	}
	
}
