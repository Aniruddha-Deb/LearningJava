package com.sensei.UIconcepts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class OpenFile extends JMenuItem{

	private ActionListener openFileListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			invokeOpenFileFrame();
		}
	};
	
	public OpenFile() {
		configureOpenFileMenu();
	}
	
	private void configureOpenFileMenu() {
		super.setText( "Open" );
		super.addActionListener( openFileListener );
	}
	
	private void invokeOpenFileFrame() {
		// TODO
	}
}
