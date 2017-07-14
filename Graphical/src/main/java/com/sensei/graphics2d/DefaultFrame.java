package com.sensei.graphics2d;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class DefaultFrame extends JFrame{
	
	private Graphics2D_01 g2d = new Graphics2D_01();

	public DefaultFrame() {
		setUpUI() ;
	}
	
	private void setUpUI() {
		Container contentPane = super.getContentPane() ;
		contentPane.setLayout( new BorderLayout() ) ;
		contentPane.add( g2d ) ;
		
		super.setSize( 400 , 400 );
		super.setVisible( true );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	private void go() {
		int x=0, y=0;
		
		for( int i=0; i<200; i++ ) {
			g2d.setXY( x, y );
			g2d.repaint();
			x++;
			y++;
			
			try {
				Thread.sleep( 20 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		DefaultFrame frame = new DefaultFrame();
		frame.go();
	}

}
