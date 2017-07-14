package com.sensei.UIconcepts;

import javax.swing.JMenu;

public class FileMenu extends JMenu{

	private OpenFile openFile = new OpenFile();
	
	public FileMenu() {
		configureFileMenu();
	}
	
	private void configureFileMenu() {
		super.add( openFile );
		super.setText( "File" );
	}
}
