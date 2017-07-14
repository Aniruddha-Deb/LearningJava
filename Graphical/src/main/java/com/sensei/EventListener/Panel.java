package com.sensei.EventListener;

import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel{
	
	JButton button = new JButton( "Button test" );
	JTextField textField = new JTextField( 15 );
	JTextArea textArea = new JTextArea( 15, 20 );
	
	public Panel( ActionListener a, KeyListener k ) {
	
		textArea.setEditable( false );
		
		JScrollPane pane = new JScrollPane( textArea );
		pane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
		
		button.addActionListener( a );
		 
		textField.addKeyListener( k );
		
		this.add( button );
		this.add( textField );
		this.add( pane );
	}
	
}
