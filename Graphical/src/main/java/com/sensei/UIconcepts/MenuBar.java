package com.sensei.UIconcepts;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{

	JMenu fileMenu = null;
	
	public MenuBar() {
		fileMenu = new JMenu();
		configureMenuBar();
	}
	
	private void configureMenuBar() {
		fileMenu.setText( "MenuBar" );
		fileMenu.setBorder(BorderFactory.createCompoundBorder(fileMenu.getBorder(),BorderFactory.createEmptyBorder(5, 0, 5, 0)));
		super.setBorderPainted( false );
		super.add( fileMenu );
	}
}
