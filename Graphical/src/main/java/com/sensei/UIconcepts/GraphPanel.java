package com.sensei.UIconcepts;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class GraphPanel extends JPanel{
	
	public GraphPanel() {
		configureGraphPanel();
	}
	
	private void configureGraphPanel() {
		super.setBorder( BorderFactory.createLineBorder( new Color( 255, 255, 255) ) );
	}

}
