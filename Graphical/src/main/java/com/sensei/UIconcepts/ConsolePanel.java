package com.sensei.UIconcepts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ConsolePanel extends JPanel{
	
	Dimension prefSize = new Dimension( 100 , 150 );
	
	public ConsolePanel() {
		configureConsolePanel();
	}
	
	private void configureConsolePanel() {
		super.setBorder( BorderFactory.createLineBorder( new Color( 255, 255, 255) ) );
		super.setPreferredSize( prefSize );
	}

}
