package com.sensei.UIconcepts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ValuePanel extends JPanel{

	Dimension prefSize = new Dimension( 300 , 200 );
	
	public ValuePanel() {
		configureValuePanel();
	}
	
	private void configureValuePanel() {
		super.setBorder( BorderFactory.createLineBorder( new Color( 255, 255, 255) ) );
		super.setPreferredSize( prefSize );
	}

}
